import java.util.*;

public class CommonElements {
    public static void main(String[] args) {
        List<Integer> a = List.of(1, 2, 3, 4, 5);
        List<Integer> b = List.of(3, 4, 5, 6, 7);
        Set<Integer> common = new LinkedHashSet<>(a);
        common.retainAll(new HashSet<>(b));
        System.out.println(common);  // [3, 4, 5]
    }
}