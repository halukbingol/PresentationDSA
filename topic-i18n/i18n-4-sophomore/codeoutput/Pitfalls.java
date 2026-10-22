import java.text.MessageFormat;
import java.util.Locale;

public class Pitfalls {
    static String f(String pattern, Object... v) {
        return new MessageFormat(pattern, Locale.US).format(v);
    }
    public static void main(String[] args) {
        System.out.println(f("Founded in {0}", 2026));               // a number!
        System.out.println(f("Founded in {0,number,#}", 2026));
        System.out.println(f("Founded in {0}", "2026"));             // or a String
        System.out.println(f("It's {0}", "late"));                   // ' starts a quote
        System.out.println(f("It''s {0}", "late"));
        System.out.println(f("Use '{0}' for the first value", "x")); // quoted: no value
        System.out.println(f("{0,number,percent} done", 0.75));
        System.out.println(f("{1} before {0}", "A", "B"));            // any order
    }
}
