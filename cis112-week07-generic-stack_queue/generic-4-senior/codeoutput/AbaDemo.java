import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AbaDemo {
    static class Node {
        final int id;
        Node(int id) { this.id = id; }
    }

    public static void main(String[] args) {
        // 1. Plain AtomicReference: ABA succeeds
        Node a = new Node(1);
        AtomicReference<Node> ref = new AtomicReference<>(a);
        Node observed = ref.get();           // we "read head = a"

        ref.set(null);                        // someone popped a
        ref.set(new Node(1));                 // someone pushed a look-alike
        ref.set(observed);                    // someone pushed the ORIGINAL a back

        System.out.println("plain CAS succeeds? " + ref.compareAndSet(observed, null));

        // 2. AtomicStampedReference: the stamp moved
        AtomicStampedReference<Node> stamped = new AtomicStampedReference<>(a, 0);
        int[] stampHolder = new int[1];
        Node observed2 = stamped.get(stampHolder);
        int observedStamp = stampHolder[0];

        stamped.set(null, observedStamp + 1);
        stamped.set(new Node(1), observedStamp + 2);
        stamped.set(observed2, observedStamp + 3);

        System.out.println("stamped CAS succeeds? " + stamped.compareAndSet(
                observed2, null, observedStamp, observedStamp + 1));
        System.out.println("current stamp = " + stamped.getStamp());
    }
}