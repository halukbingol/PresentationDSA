import java.util.NoSuchElementException;

/** A stack as a singly linked list: the top is the first node. */
public class LinkedStack<T> {
    private static final class Node<T> {
        final T item;
        final Node<T> next;
        Node(T item, Node<T> next) { this.item = item; this.next = next; }
    }

    private Node<T> top;
    private int size;

    public void push(T x) {
        top = new Node<>(x, top);          // new node points to the old top
        size++;
    }

    public T pop() {
        if (top == null) throw new NoSuchElementException("stack underflow");
        T x = top.item;
        top = top.next;                    // the old node becomes garbage
        size--;
        return x;
    }

    public T peek() {
        if (top == null) throw new NoSuchElementException("stack underflow");
        return top.item;
    }

    public boolean isEmpty() { return top == null; }
    public int size()        { return size; }
}
