import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find {
    public static void main(String[] args) {
        String text = "This term: CSE101, cis111 and MATH 151; next: CSE102.";
        Pattern course = Pattern.compile("([A-Za-z]{3,4}) ?(\\d{3})");
        Matcher m = course.matcher(text);
        while (m.find()) {
            System.out.printf("%-8s %2d-%2d %s %s%n",
                    m.group(), m.start(), m.end(), m.group(1), m.group(2));
        }
    }
}
