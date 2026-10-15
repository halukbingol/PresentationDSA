import java.util.ArrayDeque;
import java.util.Deque;

public class DequeMethods {
    public static void main(String[] args) {
        Deque<Integer> s = new ArrayDeque<>();
        s.push(1);  s.push(2);  s.push(3);              // = addFirst
        System.out.println(s + "  peek=" + s.peek() + "  peekFirst=" + s.peekFirst()
                           + "  peekLast=" + s.peekLast());
        System.out.println("pop=" + s.pop() + "  pollFirst=" + s.pollFirst() + "  now " + s);
        s.clear();
        System.out.println("empty: poll=" + s.poll() + "  peek=" + s.peek());
        try {
            s.push(null);
        } catch (NullPointerException e) {
            System.out.println("push(null): NullPointerException");
        }
    }
}
