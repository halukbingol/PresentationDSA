import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logs {
    static final Pattern LINE = Pattern.compile(
            "^(\\d{4}-\\d{2}-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) (INFO|WARN|ERROR) (.*)$",
            Pattern.MULTILINE);

    public static void main(String[] args) {
        String log = """
                2026-10-19 10:45:01 INFO server started
                2026-10-19 10:45:07 WARN slow query: 812 ms
                2026-10-19 10:46:12 ERROR student 20230001 not found
                garbage line
                2026-10-19 10:47:30 INFO login ayse
                2026-10-19 10:49:55 ERROR disk full
                """;
        Map<String, Integer> count = new TreeMap<>();
        Matcher m = LINE.matcher(log);
        while (m.find()) {
            count.merge(m.group(3), 1, Integer::sum);
            if (m.group(3).equals("ERROR")) {
                System.out.println(m.group(2) + "  " + m.group(4));
            }
        }
        System.out.println(count);
    }
}
