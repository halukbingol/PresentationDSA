import java.text.Normalizer;
import java.util.Locale;

public class Usernames {
    static String key(String name) {                       // canonical form for comparisons
        return Normalizer.normalize(name, Normalizer.Form.NFKC).toLowerCase(Locale.ROOT);
    }
    static String hex(String s) {
        StringBuilder b = new StringBuilder();
        s.codePoints().forEach(c -> b.append(String.format("%X ", c)));
        return b.toString().trim();
    }
    public static void main(String[] args) {
        String[] tries = {"admin", "ADMIN", "\uFF41dmin", "ad\u217Fin", "\u0430dmin"};
        for (String t : tries) {
            String k = key(t);
            System.out.printf("%-20s key=%-20s %s%n", hex(t), hex(k),
                k.equals("admin") ? "same as admin" : "different");
        }
    }
}
