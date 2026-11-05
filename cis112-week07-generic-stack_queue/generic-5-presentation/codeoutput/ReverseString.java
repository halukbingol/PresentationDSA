import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
    
        String s = "Yeditepe";

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
              stack.push(s.charAt(i));
        }
        
        String out = "";
        
        while (!stack.isEmpty())
        		out += stack.pop();
        
        System.out.println(s + " -> " + out);
    }
}
