import java.util.Locale;
import java.util.ResourceBundle.Control;

public class Candidates {
    public static void main(String[] args) {
        Control c = Control.getControl(Control.FORMAT_DEFAULT);
        for (String tag : new String[] {"tr-TR", "de-CH-1996", "sr-Latn-RS", "zh-TW", "nb-NO"})
            System.out.printf("%-11s %s%n", tag,
                c.getCandidateLocales("Messages", Locale.forLanguageTag(tag)));
        System.out.println("bundle name: "
            + c.toBundleName("Messages", Locale.forLanguageTag("sr-Latn-RS")));
    }
}
