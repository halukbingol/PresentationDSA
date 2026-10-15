import java.util.Map;
import java.util.TreeMap;

public class WordFreq {
    public static void main(String[] args) {
        String text = "The cat and the hat; the cat sat. And then?";
        Map<String, Integer> freq = new TreeMap<>();      // sorted keys
        for (String w : text.toLowerCase().split("[^\\p{L}]+")) {
            if (!w.isEmpty()) {
                freq.merge(w, 1, Integer::sum);           // +1
            }
        }
        System.out.println(freq);
        String top = null;
        for (String w : freq.keySet()) {
            if (top == null || freq.get(w) > freq.get(top)) {
                top = w;
            }
        }
        System.out.println("most frequent: " + top + " x" + freq.get(top));
    }
}
