import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewApis {
    public static void main(String[] args) {
        var out = System.out;
        String expr = "12+3*45-6";
        out.println(Arrays.toString(expr.split("[-+*/]")));
        out.println(Arrays.toString(expr.splitWithDelimiters("[-+*/]", 0)));

        Matcher m = Pattern.compile("(?<code>[A-Z]{3})(?<num>\\d{3})").matcher("CSE101");
        out.println(m.namedGroups());

        List<String> words = Pattern.compile("\\s*,\\s*")
                .splitAsStream("Ali , Ayşe,Can ,Zeynep")
                .map(String::toUpperCase).sorted().toList();
        out.println(words);

        out.println(Pattern.compile("\\d+").matcher("a1b22c333").results()
                .mapToInt(r -> Integer.parseInt(r.group())).sum());
    }
}
