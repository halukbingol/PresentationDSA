import java.util.*;
public class HashFlood {
    static List<String> colliding(int k) {                  // 2^k keys, one hash
        List<String> list = List.of("");
        for (int i = 0; i < k; i++) {                        // append Aa or BB
            List<String> next = new ArrayList<>();
            for (String s : list) { next.add(s + "Aa"); next.add(s + "BB"); }
            list = next;
        }
        return list;
    }
    static long fill(List<String> keys) {                   // put + get, in ms
        long t = System.nanoTime();
        Map<String, Integer> m = new HashMap<>();
        for (String s : keys) m.put(s, 1);
        for (String s : keys) m.get(s);
        return (System.nanoTime() - t) / 1_000_000;
    }
    public static void main(String[] args) {
        List<String> bad = colliding(16), good = new ArrayList<>();
        for (String s : bad) good.add(s.substring(0, 20) + good.size());
        System.out.println(bad.size() + " keys, distinct hashes: "
                + bad.stream().map(String::hashCode).distinct().count());
        fill(bad); fill(good);                                // warm up
        System.out.println("colliding " + fill(bad) + " ms, distinct " + fill(good) + " ms");
    }
}
