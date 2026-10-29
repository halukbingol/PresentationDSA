import java.util.regex.Pattern;

public class Deadline {
    /** a CharSequence that gives up after a deadline */
    record Timed(CharSequence text, long deadline) implements CharSequence {
        public char charAt(int i) {
            if (System.nanoTime() > deadline) throw new RuntimeException("regex timeout");
            return text.charAt(i);
        }
        public int length() { return text.length(); }
        public CharSequence subSequence(int s, int e) { return new Timed(text.subSequence(s, e), deadline); }
        public String toString() { return text.toString(); }
    }

    static boolean matches(Pattern p, String text, long millis) {
        long deadline = System.nanoTime() + millis * 1_000_000;
        return p.matcher(new Timed(text, deadline)).matches();
    }

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(a+)+\\1b");
        System.out.println(matches(p, "a".repeat(10), 100));
        try {
            System.out.println(matches(p, "a".repeat(40), 100));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
