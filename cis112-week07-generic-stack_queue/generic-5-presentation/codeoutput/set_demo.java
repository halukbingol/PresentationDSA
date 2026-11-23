import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        // LinkedHashSet: same uniqueness, but iterates in insertion order
        Set<String> set = new LinkedHashSet<>();
        set.add("Apple");
        set.add("Banana");
        System.out.println(set.add("Apple"));  // false: already there
        System.out.println(set);                // [Apple, Banana]
    }
}