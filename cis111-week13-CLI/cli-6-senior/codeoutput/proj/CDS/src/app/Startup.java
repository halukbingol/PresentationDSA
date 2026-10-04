package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Startup {
    public static void main(String[] args) {
        // typical start-up work: streams, lambdas, regex, dates
        List<String> tools = List.of("javac", "java", "jar", "jlink", "jpackage");
        String joined = tools.stream()
                .filter(Pattern.compile("^j").asPredicate())
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        String day = LocalDate.of(2026, 10, 2).format(DateTimeFormatter.ISO_DATE);
        System.out.println(joined + " (" + day + ")");
    }
}
