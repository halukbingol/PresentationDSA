import java.util.*;

public class DequeStack {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Java");
        stack.push("Python");
        System.out.println(stack.pop());   // Python
        System.out.println(stack.pop());   // Java
        System.out.println(stack.isEmpty()); // true
    }
}