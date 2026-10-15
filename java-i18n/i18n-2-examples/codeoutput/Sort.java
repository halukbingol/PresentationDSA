import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Sort {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of(
            "çay", "cam", "zil", "şeker", "sabun", "ılık", "ilaç", "Ömer", "ok", "Ali"));
        words.sort(null);                                   // compareTo: code points
        System.out.println(words);
        words.sort(Collator.getInstance(Locale.of("tr")));  // Turkish alphabet
        System.out.println(words);
        words.sort(Collator.getInstance(Locale.ENGLISH));   // English rules
        System.out.println(words);
    }
}
