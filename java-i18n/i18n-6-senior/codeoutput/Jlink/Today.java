import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Today {
    public static void main(String[] args) {
        StringBuilder line = new StringBuilder(Locale.getAvailableLocales().length + " locales: ");
        for (String tag : new String[] {"tr-TR", "de-DE"})
            line.append(tag).append(" = ").append(LocalDate.of(2026, 10, 15).format(DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.forLanguageTag(tag)))).append("   ");
        System.out.println(line);
    }
}
