import java.util.NoSuchElementException;

public class LinkedQueue<T> implements QueueADT<T> {
    private static final class Node<T> {
        final T item;
        Node<T> next;
        Node(T item) { this.item = item; }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void enqueue(T item) {
        Node<T> n = new Node<>(item);
        if (tail == null) { head = tail = n; }
        else { tail.next = n; tail = n; }
        size++;
    }

    public T dequeue() {
        if (head == null) throw new NoSuchElementException("queue underflow");
        T item = head.item;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return item;
    }

    public T peek() {
        if (head == null) throw new NoSuchElementException("queue underflow");
        return head.item;
    }

    public boolean isEmpty() { return head == null; }
    public int size() { return size; }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node<T> p = head; p != null; p = p.next) {
            sb.append(p.item);
            if (p.next != null) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        LinkedQueue<String> q = new LinkedQueue<>();
        q.enqueue("A"); q.enqueue("B"); q.enqueue("C");
        System.out.println("queue    = " + q);
        System.out.println("dequeue  = " + q.dequeue());
        System.out.println("queue    = " + q);
        q.enqueue("D");
        System.out.println("queue    = " + q);
    }
}