import java.util.*;

public class StackBug {
    public static void main(String[] args) {
        Deque<String> s = new ArrayDeque<>();
        s.push("only");
        System.out.println(s.pop());
        System.out.println(s.pop());   // BUG: stack is empty
    }
}