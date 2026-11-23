import java.util.LinkedList;

public class Palindrome {
    static boolean isPalindrome(LinkedList<Character> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) if (!list.get(i++).equals(list.get(j--))) return false;
        return true;
    }
    public static void main(String[] args) {
        LinkedList<Character> a = new LinkedList<>(java.util.List.of('r','a','c','e','c','a','r'));
        LinkedList<Character> b = new LinkedList<>(java.util.List.of('a','b','c'));
        System.out.println(a + ": " + isPalindrome(a));
        System.out.println(b + ": " + isPalindrome(b));
    }
}
