import java.util.Locale;

public class Locales {
    public static void main(String[] args) {
        Locale[] all = {
            Locale.of("tr", "TR"),              // Java 19+
            Locale.forLanguageTag("de-CH"),     // from a BCP 47 tag
            Locale.FRANCE,                      // a constant
            Locale.forLanguageTag("pt-BR"),
            new Locale.Builder().setLanguage("sr").setScript("Latn")
                                .setRegion("RS").build()
        };
        for (Locale l : all)
            System.out.printf("%-8s %-11s %-30s %s%n", l, l.toLanguageTag(),
                l.getDisplayName(Locale.ENGLISH), l.getDisplayName(l));
    }
}
