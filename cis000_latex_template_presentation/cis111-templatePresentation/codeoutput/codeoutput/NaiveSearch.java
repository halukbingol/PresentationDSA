import java.util.ArrayList;
import java.util.List;
public class NaiveSearch {
    static long comparisons = 0;
    static List<Integer> search(String t, String p) {
        List<Integer> hits = new ArrayList<>();
        int n = t.length(), m = p.length();
        for (int s = 0; s <= n - m; s++) {                  // every shift
            int j = 0;
            while (j < m) {
                comparisons++;
                if (t.charAt(s + j) != p.charAt(j)) break;  // mismatch
                j++;
            }
            if (j == m) hits.add(s);
        }
        return hits;
    }
    public static void main(String[] args) {
        System.out.println(search("abracadabra", "abra") + " " + comparisons);
        comparisons = 0;
        String t = "a".repeat(1000) + "b";                  // worst case
        String p = "a".repeat(10) + "b";
        System.out.println(search(t, p) + " " + comparisons + " comparisons");
        System.out.println("n * m = " + t.length() * p.length());
    }
}
