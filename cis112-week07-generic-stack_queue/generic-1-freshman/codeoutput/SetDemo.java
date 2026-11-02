import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("Apple");
        set.add("Banana");
        System.out.println(set.add("Apple"));   // duplicate
        System.out.println(set);
    }
}