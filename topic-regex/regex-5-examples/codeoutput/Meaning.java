import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Meaning {
    static final DateTimeFormatter F =
            DateTimeFormatter.ofPattern("dd.MM.uuuu").withResolverStyle(ResolverStyle.STRICT);

    public static void main(String[] args) {
        for (String s : new String[] { "26.10.2026", "31.02.2026", "29.02.2028", "99.99.2026" }) {
            String form = s.matches("\\d{2}\\.\\d{2}\\.\\d{4}") ? "form ok" : "bad form";
            String value;
            try {
                value = "date " + LocalDate.parse(s, F);
            } catch (DateTimeParseException e) {
                value = "no such date";
            }
            System.out.printf("%s  %s  %s%n", s, form, value);
        }
    }
}
