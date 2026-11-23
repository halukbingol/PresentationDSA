import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements StackADT<T>, Iterable<T> {
    private T[] a;
    private int top;   // index of the next free slot = number of elements

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("capacity < 1");
        a = (T[]) new Object[capacity];
        top = 0;
    }

    public void push(T item) {
        if (top == a.length) grow();
        a[top++] = item;
    }

    public T pop() {
        if (top == 0) throw new NoSuchElementException("stack underflow");
        T item = a[--top];
        a[top] = null;                              // avoid loitering
        if (a.length > 4 && top < a.length / 4) shrink();
        return item;
    }

    public T peek() {
        if (top == 0) throw new NoSuchElementException("stack underflow");
        return a[top - 1];
    }

    public boolean isEmpty() { return top == 0; }
    public int size() { return top; }

    @SuppressWarnings("unchecked")
    private void grow() {
        T[] b = (T[]) new Object[a.length * 2];
        System.arraycopy(a, 0, b, 0, top);
        a = b;
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        T[] b = (T[]) new Object[a.length / 2];
        System.arraycopy(a, 0, b, 0, top);
        a = b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = top - 1; i >= 0; i--) {
            sb.append(a[i]);
            if (i > 0) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = top - 1;   // iterator goes from top to bottom
            public boolean hasNext() { return i >= 0; }
            public T next() {
                if (i < 0) throw new NoSuchElementException();
                return a[i--];
            }
        };
    }
}