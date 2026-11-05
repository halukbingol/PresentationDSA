import java.util.ArrayDeque;
import java.util.List;
import java.util.SequencedCollection;

public class SequencedDemo {
    public static void main(String[] args) {
        SequencedCollection<String> d = new ArrayDeque<>();
        d.addLast("A");
        d.addLast("B");
        d.addFirst("Z");
        System.out.println("forward:  " + d);
        System.out.println("reversed: " + d.reversed());
        System.out.println("first:    " + d.getFirst());
        System.out.println("last:     " + d.getLast());

        List<String> list = List.of("x", "y", "z");
        System.out.println("list reversed: " + list.reversed());
    }
}