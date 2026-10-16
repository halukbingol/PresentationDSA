import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class FailFast {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= 4; i++) deque.push(i);
        for (int x : deque) {
            System.out.print(x + " ");
            if (x == 3) deque.push(99);         // change it while iterating
        }
        System.out.println("  ArrayDeque: no error, 99 not visited; now " + deque);

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 4; i++) stack.push(i);
        for (int x : stack) {
            System.out.print(x + " ");
            if (x == 3) stack.push(99);
        }
    }
}
