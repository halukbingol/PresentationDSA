import java.util.List;
import java.util.regex.Pattern;

public class Reuse {
    static final Pattern EMAIL = Pattern.compile("[\\w.]+@std\\.yeditepe\\.edu\\.tr");

    public static void main(String[] args) {
        List<String> inputs = List.of("ayse@std.yeditepe.edu.tr", "ali@gmail.com",
                "can.kaya@std.yeditepe.edu.tr", "zeynep@std_yeditepe.edu.tr",
                "to: deniz@std.yeditepe.edu.tr");
        List<String> students = inputs.stream().filter(EMAIL.asMatchPredicate()).toList();
        System.out.println(students);
        System.out.println(inputs.stream().filter(EMAIL.asPredicate()).count());
    }
}
