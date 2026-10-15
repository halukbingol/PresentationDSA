import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Extensions {
    public static void main(String[] args) {
        LocalDate day = LocalDate.of(2026, 10, 15);
        String[] tags = {"en-US", "en-US-u-ca-buddhist", "en-US-u-ca-japanese",
                         "tr-TR-u-ca-islamic-umalqura", "en-US-u-cu-eur", "en-US-u-fw-mon",
                         "en-US-u-rg-trzzzz"};
        for (String t : tags) {
            Locale l = Locale.forLanguageTag(t);
            System.out.printf("%-28s %-28s %-11s %s%n", t,
                day.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).localizedBy(l)),
                NumberFormat.getCurrencyInstance(l).format(1234.5),
                WeekFields.of(l).getFirstDayOfWeek());
        }
    }
}
