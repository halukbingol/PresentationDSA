import java.util.ArrayDeque;
import java.util.Deque;

public class AddFirstDemo {
    public static void main(String[] args) {
        Deque<String> q = new ArrayDeque<>();
        q.add("A");        // add == addLast
        q.offer("B");      // offer == offerLast
        q.push("Z");       // push == addFirst

        System.out.println(q);
        System.out.println("getFirst = " + q.getFirst());
        System.out.println("getLast  = " + q.getLast());

        System.out.println("removeFirst = " + q.removeFirst());
        System.out.println("pop         = " + q.pop());   // removes first too
        System.out.println("after       = " + q);
    }
}