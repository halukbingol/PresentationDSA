package lib;

import java.util.Locale;

public class TextUtil {
    static final Locale TR = Locale.forLanguageTag("tr");

    public static String shout(String s) {
        return s.toUpperCase(TR) + "!";
    }
}
