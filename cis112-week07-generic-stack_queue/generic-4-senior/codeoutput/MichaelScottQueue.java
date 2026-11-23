import java.util.concurrent.atomic.AtomicReference;

public class MichaelScottQueue<T> {
    private static final class Node<T> {
        final T item;
        final AtomicReference<Node<T>> next = new AtomicReference<>();
        Node(T item) { this.item = item; }
    }

    private final AtomicReference<Node<T>> head;
    private final AtomicReference<Node<T>> tail;

    public MichaelScottQueue() {
        Node<T> dummy = new Node<>(null);
        head = new AtomicReference<>(dummy);
        tail = new AtomicReference<>(dummy);
    }

    public void enqueue(T item) {
        Node<T> n = new Node<>(item);
        while (true) {
            Node<T> last = tail.get();
            Node<T> next = last.next.get();
            if (last == tail.get()) {
                if (next == null) {
                    if (last.next.compareAndSet(null, n)) {
                        tail.compareAndSet(last, n);
                        return;
                    }
                } else {
                    tail.compareAndSet(last, next);
                }
            }
        }
    }

    public T dequeue() {
        while (true) {
            Node<T> first = head.get();
            Node<T> last  = tail.get();
            Node<T> next  = first.next.get();
            if (first == head.get()) {
                if (first == last) {
                    if (next == null) return null;
                    tail.compareAndSet(last, next);
                } else {
                    T item = next.item;
                    if (head.compareAndSet(first, next)) return item;
                }
            }
        }
    }

    public static void main(String[] args) {
        MichaelScottQueue<Integer> q = new MichaelScottQueue<>();
        for (int i = 1; i <= 5; i++) q.enqueue(i);
        Integer x;
        while ((x = q.dequeue()) != null) System.out.println(x);
        System.out.println("done");
    }
}