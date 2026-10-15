import java.text.NumberFormat;
import java.util.Locale;

public class Compact {
    public static void main(String[] args) {
        long[] values = {1_200, 1_234_567, 3_000_000_000L};
        for (String tag : new String[] {"en-US", "tr-TR", "de-DE"}) {
            Locale l = Locale.forLanguageTag(tag);
            NumberFormat s = NumberFormat.getCompactNumberInstance(l, NumberFormat.Style.SHORT);
            NumberFormat g = NumberFormat.getCompactNumberInstance(l, NumberFormat.Style.LONG);
            StringBuilder line = new StringBuilder(tag);
            for (long v : values)
                line.append(String.format("  %-8s %-13s", s.format(v), g.format(v)));
            System.out.println(line);
        }
    }
}
