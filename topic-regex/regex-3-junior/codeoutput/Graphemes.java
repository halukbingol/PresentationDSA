import java.text.Normalizer;
import java.util.regex.Pattern;

public class Graphemes {
    public static void main(String[] args) {
        String composed = "caf\u00e9";
        String decomposed = "cafe\u0301";
        System.out.println("composed:   length " + composed.length() + ", caf\\p{L} " + composed.matches("caf\\p{L}"));
        System.out.println("decomposed: length " + decomposed.length() + ", caf\\p{L} " + decomposed.matches("caf\\p{L}"));
        System.out.println("decomposed: caf\\X " + decomposed.matches("caf\\X"));
        System.out.println(Pattern.compile("\\X").matcher(decomposed).results().count() + " graphemes");
        String nfc = Normalizer.normalize(decomposed, Normalizer.Form.NFC);
        System.out.println("after NFC:  length " + nfc.length() + ", caf\\p{L} " + nfc.matches("caf\\p{L}"));
    }
}
