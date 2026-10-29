import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dates {
    public static void main(String[] args) {
        String text = "Midterm 18.11.2026, final 13.01.2027, make-up 1.2.2027.";
        Pattern date = Pattern.compile("(\\d{1,2})\\.(\\d{1,2})\\.(\\d{4})");

        Matcher m = date.matcher(text);
        while (m.find()) {
            System.out.printf("%-10s day %-2s month %-2s year %s%n",
                    m.group(), m.group(1), m.group(2), m.group(3));
        }
        System.out.println(date.matcher(text).replaceAll("$3-$2-$1"));
    }
}
