import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class SortStrings {
    public static void main(String[] args) {
        String[] a = {"zeytin", "Elma", "çay", "armut",
                      "ılık", "incir", "Üzüm"};
        Arrays.sort(a);                                  // char codes
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(a));
        Collator tr = Collator.getInstance(Locale.forLanguageTag("tr"));
        Arrays.sort(a, tr);                              // Turkish alphabet
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Comparator.comparing(String::length)
                                 .thenComparing(tr));    // length, then tr
        System.out.println(Arrays.toString(a));
    }
}
