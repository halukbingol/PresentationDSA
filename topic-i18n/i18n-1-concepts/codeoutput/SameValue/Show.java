import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Show {
    public static void main(String[] args) {
        LocalDate day = LocalDate.of(2026, 10, 15);
        for (String tag : args) {
            Locale l = Locale.forLanguageTag(tag);
            System.out.printf("%-6s %-14s %-17s %-5s %s%n", tag,
                NumberFormat.getInstance(l).format(1234567.891),
                NumberFormat.getCurrencyInstance(l).format(1234.5),
                NumberFormat.getPercentInstance(l).format(0.25),
                day.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(l)));
        }
    }
}
