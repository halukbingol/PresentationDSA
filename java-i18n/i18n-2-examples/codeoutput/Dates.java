import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Dates {
    public static void main(String[] args) {
        LocalDateTime t = LocalDateTime.of(2026, 10, 15, 14, 30);
        for (String tag : new String[] {"en-US", "tr-TR", "de-DE"}) {
            Locale l = Locale.forLanguageTag(tag);
            System.out.println(tag);
            for (FormatStyle s : new FormatStyle[] {FormatStyle.FULL, FormatStyle.MEDIUM,
                                                    FormatStyle.SHORT})
                System.out.printf("  %-6s %s%n", s, t.format(
                    DateTimeFormatter.ofLocalizedDate(s).withLocale(l)));
            System.out.println("  time   " + t.format(
                DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(l)));
        }
        System.out.println(t.format(DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy",
                                                                Locale.of("tr"))));
    }
}
