import java.util.Locale;

public class Mapping {
static String hex(String s) {                       // code points as hex
    StringBuilder b = new StringBuilder();
    s.codePoints().forEach(c -> b.append(String.format("%X ", c)));
    return b.toString().trim();
}

    public static void main(String[] args) {
        Locale tr = Locale.of("tr");
        String[] words = {"straße", "\uFB01le", "İstanbul", "DİYARBAKIR"};
        for (String w : words) {
            String up = w.toUpperCase(Locale.ROOT), low = w.toLowerCase(Locale.ROOT);
            System.out.printf("%-26s upper=%-11s lower(tr)=%-11s length %d -> %d / %d%n",
                hex(w), up, w.toLowerCase(tr), w.length(), up.length(), low.length());
        }
        System.out.println("İ lower(ROOT): " + hex("İ".toLowerCase(Locale.ROOT)));
        System.out.println("char level:    " + Character.toUpperCase('ß') + " (no change)");
        System.out.println("straße equalsIgnoreCase STRASSE: " + "straße".equalsIgnoreCase("STRASSE"));
    }
}
