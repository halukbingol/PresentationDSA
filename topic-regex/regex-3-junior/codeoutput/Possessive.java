import java.util.regex.Pattern;

public class Possessive {
    static void show(String regex, String text) {
        System.out.printf("%-12s %-8s %b%n", regex, text, Pattern.compile(regex).matcher(text).matches());
    }

    public static void main(String[] args) {
        show("a*a", "aaaa");
        show("a*+a", "aaaa");
        show("(?>a*)a", "aaaa");
        show("\"[^\"]*+\"", "\"text\"");
        show("\\d++\\.\\d+", "3.14");
    }
}
