public class LinkedDeque<T> implements DequeADT<T> {
    private static class Node<T> {
        T data; Node<T> prev, next;
        Node(T data) { this.data = data; }
    }
    private Node<T> head, tail;

    public void addFirst(T item) {
        Node<T> n = new Node<>(item);
        if (head == null) { head = tail = n; return; }
        n.next = head; head.prev = n; head = n;
    }

    public void addLast(T item) {
        Node<T> n = new Node<>(item);
        if (tail == null) { head = tail = n; return; }
        tail.next = n; n.prev = tail; tail = n;
    }

    public T removeFirst() {
        if (head == null) throw new RuntimeException("empty");
        T val = head.data;
        head = head.next;
        if (head == null) tail = null; else head.prev = null;
        return val;
    }

    public T removeLast() {
        if (tail == null) throw new RuntimeException("empty");
        T val = tail.data;
        tail = tail.prev;
        if (tail == null) head = null; else tail.next = null;
        return val;
    }
    public boolean isEmpty() { return head == null; }

    public static void main(String[] args) {
        LinkedDeque<String> d = new LinkedDeque<>();
        d.addLast("B"); d.addFirst("A"); d.addLast("C");
        System.out.println(d.removeLast());  // C
        System.out.println(d.removeFirst()); // A
        System.out.println(d.removeFirst()); // B
    }
}
