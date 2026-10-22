import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Locale.Category;

public class Cat {
    public static void main(String[] args) {
        System.out.println("DISPLAY=" + Locale.getDefault(Category.DISPLAY)
            + " FORMAT=" + Locale.getDefault(Category.FORMAT));
        System.out.println(Locale.FRANCE.getDisplayName()               // uses DISPLAY
            + " | " + String.format("%,.2f", 1234.5)                    // uses FORMAT
            + " | " + LocalDate.of(2026, 10, 15).format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));  // uses FORMAT
    }
}
