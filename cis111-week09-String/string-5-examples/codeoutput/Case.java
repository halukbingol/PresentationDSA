import java.util.Locale;

public class Case {
    public static void main(String[] args) {
        Locale tr = Locale.forLanguageTag("tr");
        String city = "istanbul";
        String word = "TITLE";
        System.out.println(city.toUpperCase(Locale.ROOT));
        System.out.println(city.toUpperCase(tr));
        System.out.println(word.toLowerCase(Locale.ROOT));
        System.out.println(word.toLowerCase(tr));
        System.out.println("ÇİĞDEM".toLowerCase(tr));
        System.out.println("ılık".toUpperCase(Locale.ROOT));
    }
}
