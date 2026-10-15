import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {
    public static void main(String[] args) {
        Locale l = Locale.forLanguageTag(args[0]);
        ResourceBundle rb = ResourceBundle.getBundle("Messages", l);
        System.out.println("[" + rb.getLocale() + "] "
            + MessageFormat.format(rb.getString("greet"), "Ayşe") + " | "
            + rb.getString("save") + " | " + rb.getString("quit"));
    }
}
