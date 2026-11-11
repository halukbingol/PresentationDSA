import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String text = "Exams: 2026-01-12 (CSE 101), 2026-01-15 (CSE 211).";
        Pattern date = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
        Matcher m = date.matcher(text);
        while (m.find()) {
            System.out.println(m.group() + ": day " + m.group(3));
        }
        Pattern course = Pattern.compile("(?<dept>[A-Z]{3}) (?<num>\\d{3})");
        Matcher c = course.matcher(text);
        while (c.find()) {
            System.out.println(c.group("dept") + "/" + c.group("num"));
        }
        System.out.println(date.matcher(text).replaceAll("$3.$2.$1"));
        String mail = "[\\w.]+@[\\w.]+\\.[a-z]{2,}";
        System.out.println("ali.veli@example.edu.tr".matches(mail));
        System.out.println("Çağrı".matches("\\w+"));       // ASCII only
        System.out.println("Çağrı".matches("\\p{L}+"));    // any letter
    }
}
