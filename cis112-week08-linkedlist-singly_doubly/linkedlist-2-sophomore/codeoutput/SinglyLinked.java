import java.util.NoSuchElementException;

public class SinglyLinked<T> implements LinkedListADT<T>, Iterable<T> {
    private static final class Node<T> {
        final T item; Node<T> next;
        Node(T item, Node<T> next) { this.item = item; this.next = next; }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T item) {
        head = new Node<>(item, head);
        if (tail == null) tail = head;
        size++;
    }
    public T removeFirst() {
        if (head == null) throw new NoSuchElementException();
        T x = head.item;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return x;
    }
    public boolean contains(T item) {
        for (Node<T> p = head; p != null; p = p.next)
            if (p.item.equals(item)) return true;
        return false;
    }
    public void addLast(T item) {
        Node<T> n = new Node<>(item, null);
        if (tail == null) head = tail = n; else { tail.next = n; tail = n; }
        size++;
    }
    public T removeLast() {
        if (tail == null) throw new NoSuchElementException();
        if (head == tail) { T x = head.item; head = tail = null; size--; return x; }
        Node<T> p = head;
        while (p.next != tail) p = p.next;
        T x = tail.item;
        p.next = null; tail = p; size--;
        return x;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            Node<T> p = head;
            public boolean hasNext() { return p != null; }
            public T next() {
                if (p == null) throw new NoSuchElementException();
                T x = p.item; p = p.next; return x;
            }
        };
    }

    public static void main(String[] args) {
        SinglyLinked<Integer> s = new SinglyLinked<>();
        s.addFirst(1); s.addFirst(2); s.addLast(3);
        System.out.println("contains 2: " + s.contains(2));
        for (int x : s) System.out.println(x);
        System.out.println("removeFirst: " + s.removeFirst());
        System.out.println("removeLast:  " + s.removeLast());
    }
}
