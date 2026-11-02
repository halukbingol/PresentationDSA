import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Yeditepe";
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) stack.push(c);
        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()) out.append(stack.pop());
        System.out.println(s + " -> " + out);
    }
}