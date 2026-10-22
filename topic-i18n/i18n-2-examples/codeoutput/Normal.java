import java.text.Normalizer;

public class Normal {
    static String hex(String s) {                   // the code points, e.g. "43 61 66 E9"
        StringBuilder b = new StringBuilder();
        s.codePoints().forEach(c -> b.append(String.format("%X ", c)));
        return b.toString();
    }
    public static void main(String[] args) {
        String one = "Caf\u00e9";          // é as one code point
        String two = "Cafe\u0301";         // e + combining acute accent
        System.out.println("one: " + hex(one) + "  length " + one.length());
        System.out.println("two: " + hex(two) + "  length " + two.length());
        System.out.println("equal? " + one.equals(two));
        String n1 = Normalizer.normalize(one, Normalizer.Form.NFC);
        String n2 = Normalizer.normalize(two, Normalizer.Form.NFC);
        System.out.println("after NFC: " + hex(n2) + " equal? " + n1.equals(n2));
    }
}
