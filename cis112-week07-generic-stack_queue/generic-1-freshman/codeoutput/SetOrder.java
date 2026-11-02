import java.util.*;

public class SetOrder {
    public static void main(String[] args) {
        List<String> words = List.of("pear", "apple", "fig", "banana", "cherry");
        System.out.println("HashSet:       " + new HashSet<>(words));
        System.out.println("LinkedHashSet: " + new LinkedHashSet<>(words));
        System.out.println("TreeSet:       " + new TreeSet<>(words));
    }
}