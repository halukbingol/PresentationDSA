import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {
    static long comparisons = 0;

    static int[] prefix(String p) {       // pi[q]: longest border
        int[] pi = new int[p.length()];   //        of p[0..q]
        int k = 0;
        for (int q = 1; q < p.length(); q++) {
            while (k > 0 && p.charAt(k) != p.charAt(q)) {
                k = pi[k - 1];
            }
            if (p.charAt(k) == p.charAt(q)) k++;
            pi[q] = k;
        }
        return pi;
    }

    static List<Integer> search(String t, String p) {
        int[] pi = prefix(p);
        List<Integer> hits = new ArrayList<>();
        int q = 0;                        // characters matched
        for (int i = 0; i < t.length(); i++) {
            while (q > 0 && p.charAt(q) != t.charAt(i)) {
                comparisons++;
                q = pi[q - 1];            // fall back, i stays
            }
            comparisons++;
            if (p.charAt(q) == t.charAt(i)) q++;
            if (q == p.length()) {        // match ends at i
                hits.add(i - q + 1);
                q = pi[q - 1];
            }
        }
        return hits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(prefix("ababaca")));
        System.out.println(search("abracadabra", "abra"));
        comparisons = 0;
        String t = "a".repeat(1000) + "b", p = "a".repeat(10) + "b";
        System.out.println(search(t, p) + " " + comparisons + " comparisons");
    }
}
