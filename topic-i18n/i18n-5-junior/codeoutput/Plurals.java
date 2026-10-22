import java.text.NumberFormat;
import java.util.Locale;

public class Plurals {
    public static void main(String[] args) {
        long[] counts = {1, 2, 5, 22, 25};
        for (String tag : new String[] {"en", "tr", "de", "fr", "pl"}) {
            NumberFormat f = NumberFormat.getCompactNumberInstance(
                Locale.forLanguageTag(tag), NumberFormat.Style.LONG);
            StringBuilder line = new StringBuilder(String.format("%-3s", tag));
            for (long c : counts) {
                String s = f.format(c * 1_000_000);
                line.append(String.format(" | %-17s", s));
            }
            System.out.println(line);
        }
    }
}
