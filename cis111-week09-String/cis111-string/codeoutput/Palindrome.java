public class Palindrome {
    static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"kayak", "Level", "java",
                          "ey edip adanada pide ye"};
        for (String w : words) {
            System.out.println(w + " -> " + isPalindrome(w));
        }
    }
}
