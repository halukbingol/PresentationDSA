import java.util.Locale;
import java.util.ResourceBundle;

public class Show {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle(args[0], Locale.of("tr"));
        System.out.println(args[0] + ": " + rb.getString("quit"));
    }
}
