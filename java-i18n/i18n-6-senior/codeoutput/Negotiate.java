import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;

public class Negotiate {
    public static void main(String[] args) {
        List<Locale> supported = List.of(Locale.ENGLISH, Locale.of("tr"), Locale.GERMAN);
        String[] headers = {                       // HTTP Accept-Language from browsers
            "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7",
            "de-CH,fr;q=0.8",
            "fr-FR,fr;q=0.9,en;q=0.5",
            "ja-JP",
            "*;q=0.1,de;q=0.5"};
        for (String h : headers) {
            List<LanguageRange> wanted = LanguageRange.parse(h);
            Locale best = Locale.lookup(wanted, supported);       // RFC 4647 lookup
            System.out.printf("%-38s -> %s%n", h, best == null ? "(none: use the default)" : best);
        }
    }
}
