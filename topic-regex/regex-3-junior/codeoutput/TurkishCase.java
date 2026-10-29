import java.util.Locale;
import java.util.regex.Pattern;

public class TurkishCase {
    static final int CI = Pattern.CASE_INSENSITIVE;
    static final int UC = CI | Pattern.UNICODE_CASE;

    static void test(String regex, String text, int flags) {
        String name = flags == CI ? "CI" : "CI+UC";
        System.out.printf("%-8s %-8s %-5s %b%n", regex, text, name,
                Pattern.compile(regex, flags).matcher(text).matches());
    }

    public static void main(String[] args) {
        test("şişli", "ŞİŞLİ", CI);
        test("şişli", "ŞİŞLİ", UC);
        test("ılık", "ILIK", UC);
        test("ilik", "ILIK", UC);
        test("istanbul", "İSTANBUL", UC);

        String input = "ŞİŞLİ".toLowerCase(Locale.forLanguageTag("tr"));
        System.out.println(input + " " + input.matches("şişli"));
    }
}
