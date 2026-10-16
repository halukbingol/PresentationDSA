import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LegacyStack {
    public static void main(String[] args) {
        Stack<String> old = new Stack<>();
        Deque<String> deque = new ArrayDeque<>();
        for (String x : new String[] {"a", "b", "c"}) {
            old.push(x);
            deque.push(x);
        }
        System.out.println("Stack      " + old + "   peek " + old.peek());
        System.out.println("ArrayDeque " + deque + "   peek " + deque.peek());
        System.out.println("old.search(\"a\") = " + old.search("a"));
        old.add(0, "z");                      // allowed: Stack is a Vector
        System.out.println("after add(0, \"z\"): " + old);
        old.clear();
        old.pop();
    }
}
