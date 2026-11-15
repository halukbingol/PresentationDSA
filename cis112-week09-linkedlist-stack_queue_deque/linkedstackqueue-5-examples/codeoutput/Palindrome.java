import java.util.ArrayDeque;
import java.util.Deque;

public class Palindrome {

    static boolean isPalindrome(String s) {

        Deque<Character> d = new ArrayDeque<>();

        for (char c : s.toCharArray()) 
		d.addLast(c);
        while (d.size() > 1) {
            if (d.removeFirst() != d.removeLast()) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("radar"));
        System.out.println(isPalindrome("java"));
    }
}
