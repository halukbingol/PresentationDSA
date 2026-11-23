import java.util.*;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        System.out.println(stack.peek());  // Python
        System.out.println(stack.pop());   // Python
        System.out.println(stack.pop());   // Java
    }
}