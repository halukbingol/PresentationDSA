import java.text.Normalizer;
import java.text.Normalizer.Form;

public class Forms {
static String hex(String s) {                       // code points as hex
    StringBuilder b = new StringBuilder();
    s.codePoints().forEach(c -> b.append(String.format("%X ", c)));
    return b.toString().trim();
}

    public static void main(String[] args) {
        String[] samples = {"\u00E9", "e\u0301", "\uFB01le", "\uFF21\uFF22\uFF11", "x\u00B2", "\u2163"};
        System.out.printf("%-14s %-14s %-14s %s%n", "input", "NFC", "NFD", "NFKC");
        for (String s : samples)
            System.out.printf("%-14s %-14s %-14s %s%n", hex(s),
                hex(Normalizer.normalize(s, Form.NFC)), hex(Normalizer.normalize(s, Form.NFD)),
                hex(Normalizer.normalize(s, Form.NFKC)));
    }
}
