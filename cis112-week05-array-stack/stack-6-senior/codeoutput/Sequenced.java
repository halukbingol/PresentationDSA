import java.util.*;

public class Sequenced {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        Stack<String> stack = new Stack<>();
        for (String x : List.of("a", "b", "c")) { deque.push(x); stack.push(x); }

        System.out.println("Deque iterates top first:    " + deque);
        System.out.println("Stack iterates bottom first: " + stack);

        // Java 21: both are SequencedCollections
        System.out.println("deque.reversed():            " + deque.reversed());
        System.out.println("stack.reversed():            " + stack.reversed());
        System.out.println("getFirst / getLast:          " + deque.getFirst() + " " + stack.getLast());

        stack.add(1, "X");                    // Vector methods break the LIFO rule
        stack.remove("a");
        System.out.println("after add(1, X), remove(a):  " + stack);
    }
}
