import java.util.LinkedHashMap;

public class LruCache {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(3, 0.75f, true) {
            @Override protected boolean removeEldestEntry(java.util.Map.Entry<String, Integer> e) {
                return size() > 3;
            }
        };
        cache.put("a", 1); cache.put("b", 2); cache.put("c", 3);
        cache.get("a");
        cache.put("d", 4);   // evicts b (least recently used)
        System.out.println(cache);
    }
}
