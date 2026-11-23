import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        System.out.println(set.add("Apple"));  // false: already there
        System.out.println(set);                // [Apple, Banana]
    }
}