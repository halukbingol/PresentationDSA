import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> s = new ArrayDeque<>();
        s.push("a");
        s.push("b");
        s.push("c");
        System.out.println(s + "  peek " + s.peek());
        System.out.println("pop  " + s.pop() + " " + s.pop() + " " + s.pop());
        System.out.println("poll " + s.poll());        // empty: null
        System.out.println("peek " + s.peek());        // empty: null
        s.pop();                                      // empty: exception
    }
}
