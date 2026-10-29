import java.util.regex.Pattern;

public class Greedy {
    static void show(String regex, String text) {
        System.out.printf("%-10s %s%n", regex, Pattern.compile(regex).matcher(text).results()
                .map(r -> r.group()).toList());
    }

    public static void main(String[] args) {
        String html = "<b>bold</b> and <b>more</b>";
        show("<b>.*</b>", html);
        show("<b>.*?</b>", html);
        show("<b>[^<]*</b>", html);
    }
}
