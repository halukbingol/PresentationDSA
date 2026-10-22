import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Prov {
    public static void main(String[] args) {
        Locale ch = Locale.forLanguageTag("de-CH");
        System.out.println(NumberFormat.getInstance(ch).format(1234567.5) + " | "
            + NumberFormat.getCompactNumberInstance(Locale.GERMAN, NumberFormat.Style.LONG)
                .format(2_000_000) + " | "
            + LocalDate.of(2026, 10, 15).format(DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.of("tr"))));
    }
}
