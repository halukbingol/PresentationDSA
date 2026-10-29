import java.util.regex.Pattern;

public class Balanced {
    // at most two levels: ( ... ( ... ) ... )
    static final Pattern DEPTH2 = Pattern.compile("\\((?:[^()]|\\([^()]*\\))*\\)");

    static boolean balanced(String s) {
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') depth++;
            if (c == ')' && --depth < 0) return false;
        }
        return depth == 0;
    }

    public static void main(String[] args) {
        for (String s : new String[] { "(a)", "(a(b)c)", "((a))", "(((a)))", "(()" }) {
            System.out.printf("%-8s regex %-5b counter %b%n", s,
                    DEPTH2.matcher(s).matches(), balanced(s));
        }
    }
}
