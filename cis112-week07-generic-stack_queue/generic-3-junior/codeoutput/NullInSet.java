import java.util.HashSet;
import java.util.Set;

public class NullInSet {
    public static void main(String[] args) {
        Set<StringBuilder> s = new HashSet<>();
        s.add(new StringBuilder("a"));
        s.add(new StringBuilder("a"));
        System.out.println("size = " + s.size());

        StringBuilder k = new StringBuilder("key");
        Set<StringBuilder> s2 = new HashSet<>();
        s2.add(k);
        k.append(" changed");
        System.out.println("contains(original k) = " + s2.contains(k));
    }
}