import java.util.Arrays;
public class Anagram {
    static boolean bySorting(String a, String b) {   // O(n log n)
        char[] x = a.toCharArray(), y = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x, y);
    }
    static boolean byCounting(String a, String b) {  // O(n), a-z only
        if (a.length() != b.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }
        for (int c : count) if (c != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        String[][] pairs = {{"listen", "silent"}, {"evil", "vile"}, {"java", "jaguar"}};
        for (String[] p : pairs)
            System.out.println(p[0] + " " + p[1] + ": " + bySorting(p[0], p[1])
                               + " " + byCounting(p[0], p[1]));
    }
}
