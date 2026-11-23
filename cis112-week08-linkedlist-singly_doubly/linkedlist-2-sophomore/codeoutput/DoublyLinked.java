import java.util.NoSuchElementException;

public class DoublyLinked<T> {
    private static final class Node<T> {
        T item; Node<T> next, prev;
        Node(T item) { this.item = item; }
    }
    private Node<T> head, tail;
    private int size;

    public void addFirst(T item) {
        Node<T> n = new Node<>(item);
        if (head == null) head = tail = n;
        else { n.next = head; head.prev = n; head = n; }
        size++;
    }

    public void addLast(T item) {
        Node<T> n = new Node<>(item);
        if (tail == null) head = tail = n;
        else { n.prev = tail; tail.next = n; tail = n; }
        size++;
    }

    public boolean remove(T item) {
        for (Node<T> p = head; p != null; p = p.next) {
            if (!p.item.equals(item)) continue;
            if (p.prev == null) head = p.next; else p.prev.next = p.next;
            if (p.next == null) tail = p.prev; else p.next.prev = p.prev;
            size--;
            return true;
        }
        return false;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public static void main(String[] args) {
        DoublyLinked<String> d = new DoublyLinked<>();
        d.addFirst("b"); d.addFirst("a"); d.addLast("c");
        System.out.println("size: " + d.size());
        System.out.println("remove b: " + d.remove("b"));
        System.out.println("remove z: " + d.remove("z"));
    }
}
