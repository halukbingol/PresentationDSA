import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

public class Lookup {
    public static void main(String[] args) {
        Locale want = Locale.forLanguageTag(args[0]);
        ResourceBundle a = ResourceBundle.getBundle("Texts", want);
        ResourceBundle b = ResourceBundle.getBundle("Texts", want,
            Control.getNoFallbackControl(Control.FORMAT_DEFAULT));   // no default locale
        System.out.println("default control: [" + a.getLocale() + "] " + a.getString("hi"));
        System.out.println("no fallback:     [" + b.getLocale() + "] " + b.getString("hi"));
    }
}
