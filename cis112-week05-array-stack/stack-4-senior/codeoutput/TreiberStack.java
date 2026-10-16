import java.util.concurrent.atomic.AtomicReference;

/** A lock-free stack (R. K. Treiber, IBM, 1986). */
public class TreiberStack<T> {
    private record Node<T>(T item, Node<T> next) { }
    private final AtomicReference<Node<T>> top = new AtomicReference<>();

    public void push(T x) {
        Node<T> old, fresh;
        do {
            old = top.get();
            fresh = new Node<>(x, old);
        } while (!top.compareAndSet(old, fresh));     // retry if another thread won
    }

    public T pop() {                                  // null when empty
        Node<T> old;
        do {
            old = top.get();
            if (old == null) return null;
        } while (!top.compareAndSet(old, old.next()));
        return old.item();
    }
}
