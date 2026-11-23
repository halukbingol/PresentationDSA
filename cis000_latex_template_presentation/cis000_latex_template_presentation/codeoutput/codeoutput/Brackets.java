import java.util.ArrayDeque;
import java.util.Deque;

public class Brackets {
    static boolean balanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if ("([{".indexOf(c) >= 0) {
                stack.push(c);                       // opening: push
            } else if (")]}".indexOf(c) >= 0) {
                if (stack.isEmpty()) return false;   // nothing to close
                char open = stack.pop();             // closing: pop
                if ("([{".indexOf(open) != ")]}".indexOf(c)) return false;
            }
        }
        return stack.isEmpty();                      // all closed?
    }

    public static void main(String[] args) {
        String[] tests = {"{[()]}", "a(b[c]d)e", "([)]", "((", "))"};
        for (String s : tests) {
            System.out.println(s + " -> " + balanced(s));
        }
    }
}
