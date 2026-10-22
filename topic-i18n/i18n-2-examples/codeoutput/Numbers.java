import java.text.NumberFormat;
import java.util.Locale;

public class Numbers {
    public static void main(String[] args) {
        double x = 1234567.891;
        for (String tag : new String[] {"en-US", "tr-TR", "de-DE", "fr-FR", "de-CH"}) {
            Locale l = Locale.forLanguageTag(tag);
            System.out.printf("%-6s %-14s %-11s %-5s %s%n", tag,
                NumberFormat.getNumberInstance(l).format(x),
                NumberFormat.getIntegerInstance(l).format(x),
                NumberFormat.getPercentInstance(l).format(0.25),
                NumberFormat.getCurrencyInstance(l).format(x));
        }
    }
}
