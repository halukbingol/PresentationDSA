import java.util.regex.Pattern;

public class LookAround {
    static void show(String regex, String text) {
        System.out.printf("%-18s %s%n", regex, Pattern.compile(regex).matcher(text).results()
                .map(r -> r.group()).toList());
    }

    public static void main(String[] args) {
        String text = "simit ₺20, tea ₺15, 3 cups, 2026, $40";
        show("\\d+", text);
        show("(?<=₺)\\d+", text);
        show("(?<![₺$\\d])\\d+", text);
        show("\\d+(?= cups)", text);
        show("\\b\\d{4}\\b(?!,)", "2026, 2027 and 2028");
    }
}
