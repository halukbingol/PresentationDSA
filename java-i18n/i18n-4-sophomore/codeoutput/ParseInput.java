import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ParseInput {
    static void number(String s, Locale l) {
        ParsePosition pos = new ParsePosition(0);
        Number n = NumberFormat.getInstance(l).parse(s, pos);
        boolean all = pos.getIndex() == s.length();          // everything used?
        System.out.printf("%-9s %-6s -> %s%n", s, l, all ? n : "error at " + pos.getIndex());
    }
    static void date(String s, Locale l) {
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(l);
        try { System.out.printf("%-10s %-6s -> %s%n", s, l, LocalDate.parse(s, f)); }
        catch (DateTimeParseException e) { System.out.printf("%-10s %-6s -> %s%n", s, l, "not a date"); }
    }
    public static void main(String[] args) {
        Locale tr = Locale.of("tr", "TR");
        number("1.234,5", tr);  number("1.234,5", Locale.US);  number("12,5 kg", tr);
        date("15.10.2026", tr); date("10/15/26", Locale.US);   date("15.10.2026", Locale.US);
    }
}
