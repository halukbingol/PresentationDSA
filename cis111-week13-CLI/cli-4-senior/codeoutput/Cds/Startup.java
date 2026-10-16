import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Startup {
    public static void main(String[] args) {
        var words = List.of("javac", "java", "jar", "jlink", "jpackage");
        var p = Pattern.compile("^j.*k");
        String s = words.stream().filter(w -> p.matcher(w).find())
                        .map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(LocalDate.of(2026, 10, 13) + ": " + s);
    }
}
