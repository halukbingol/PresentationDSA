import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Syntax {
    static void tryCompile(String regex) {
        try {
            Pattern.compile(regex);
            System.out.println(regex + "  is fine");
        } catch (PatternSyntaxException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        tryCompile("(ab");
        tryCompile("*.java");
        tryCompile("[a-z");
        tryCompile("a{3,1}");
        tryCompile("\\*\\.java");
    }
}
