import java.util.regex.Pattern;

public class ReDoS {
    static double ms(Pattern p, String s) {
        long t = System.nanoTime();
        p.matcher(s).matches();                            // always false here
        return (System.nanoTime() - t) / 1e6;
    }

    public static void main(String[] args) {
        Pattern nested = Pattern.compile("(a+)+b");        // textbook case
        Pattern evil = Pattern.compile("(.*a){20}");       // still explodes
        Pattern fixed = Pattern.compile("([^a]*a){19}.*a"); // same language
        System.out.println(" n   (a+)+b  (.*a){20}  rewritten   [ms]");
        for (int n = 14; n <= 26; n += 4) {
            String s = "a".repeat(n) + "!";
            System.out.printf("%2d %8.1f %10.1f %10.2f%n",
                    n, ms(nested, s), ms(evil, s), ms(fixed, s));
        }
    }
}
