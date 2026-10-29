import java.util.regex.Pattern;

public class Whole {
    public static void main(String[] args) {
        String text = "Room 2026 is on floor 3";
        System.out.println(text.matches("\\d+"));
        System.out.println(text.matches(".*\\d+.*"));
        System.out.println(Pattern.compile("\\d+").matcher(text).find());
    }
}
