import java.text.Normalizer;
import java.util.Locale;

public class UnicodeDemo {
    static String hex(String s) {                         // chars as hex codes
        StringBuilder sb = new StringBuilder();
        s.chars().forEach(c -> sb.append(String.format("\\u%04X", c)));
        return sb.toString();
    }
    public static void main(String[] args) {
        String smile = "Hi \uD83D\uDE00";                  // "Hi " + U+1F600
        System.out.println(smile.length() + " chars, "
                + smile.codePointCount(0, smile.length()) + " code points");
        smile.codePoints().forEach(cp -> System.out.printf("U+%04X ", cp));
        System.out.println();
        String rev = new StringBuilder(smile).reverse().toString();
        System.out.println("pair kept by reverse(): " + (rev.codePointAt(0) == 0x1F600));
        String dotI = "\u0130";                             // capital dotted I
        System.out.println("ROOT lower: " + hex(dotI.toLowerCase(Locale.ROOT)));
        System.out.println("tr   lower: " + hex(dotI.toLowerCase(Locale.forLanguageTag("tr"))));
        String e1 = "\u00E9", e2 = "e\u0301";               // e-acute, e + accent
        String n2 = Normalizer.normalize(e2, Normalizer.Form.NFC);
        System.out.println(hex(e1) + " vs " + hex(e2) + ": " + e1.equals(e2));
        System.out.println("after NFC: " + e1.equals(n2));
    }
}
