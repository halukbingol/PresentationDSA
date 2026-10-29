import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Named {
    static final Pattern DATE =
            Pattern.compile("(?<day>\\d{1,2})\\.(?<month>\\d{1,2})\\.(?<year>\\d{4})");

    public static void main(String[] args) {
        Matcher m = DATE.matcher("Midterm: 4.11.2026, room B-210");
        if (m.find()) {
            int day = Integer.parseInt(m.group("day"));
            int month = Integer.parseInt(m.group("month"));
            int year = Integer.parseInt(m.group("year"));
            System.out.println(m.group() + " -> " + year + "/" + month + "/" + day);
        }
        System.out.println("4.11.2026".replaceAll(DATE.pattern(), "${year}-${month}-${day}"));
    }
}
