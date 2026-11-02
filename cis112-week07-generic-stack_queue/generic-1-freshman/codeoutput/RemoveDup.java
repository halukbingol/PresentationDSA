import java.util.*;

public class RemoveDup {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("a", "b", "a", "c", "b", "d");
        List<String> result = new ArrayList<>(new LinkedHashSet<>(words));
        System.out.println("before: " + words);
        System.out.println("after:  " + result);
    }
}