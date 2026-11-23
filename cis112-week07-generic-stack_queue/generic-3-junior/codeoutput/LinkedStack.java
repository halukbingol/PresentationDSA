import java.util.NoSuchElementException;

public class LinkedStack<T> implements StackADT<T> {
    private static final class Node<T> {
        final T item;
        final Node<T> next;
        Node(T item, Node<T> next) { this.item = item; this.next = next; }
    }
    private Node<T> top;
    private int size;

    public void push(T item) {
        top = new Node<>(item, top);
        size++;
    }

    public T pop() {
        if (top == null) throw new NoSuchElementException("stack underflow");
        T item = top.item;
        top = top.next;
        size--;
        return item;
    }

    public T peek() {
        if (top == null) throw new NoSuchElementException("stack underflow");
        return top.item;
    }

    public boolean isEmpty() { return top == null; }
    public int size() { return size; }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node<T> p = top; p != null; p = p.next) {
            sb.append(p.item);
            if (p.next != null) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> s = new LinkedStack<>();
        for (int i = 1; i <= 4; i++) s.push(i);
        System.out.println("stack = " + s);
        System.out.println("pop   = " + s.pop());
        System.out.println("pop   = " + s.pop());
        System.out.println("stack = " + s);
    }
}