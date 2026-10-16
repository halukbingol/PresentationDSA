import java.util.Arrays;
import java.util.NoSuchElementException;

/** A stack in an array that grows and shrinks. */
public class ArrayStack<T> {
    private T[] a;          // the elements are a[0] .. a[size - 1]
    private int size;       // number of elements; the top is a[size - 1]

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        a = (T[]) new Object[1];
    }

    public void push(T x) {
        if (size == a.length) resize(2 * a.length);     // full: double
        a[size++] = x;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        T x = a[--size];
        a[size] = null;                                  // no loitering
        if (size > 0 && size == a.length / 4) resize(a.length / 2);
        return x;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        return a[size - 1];
    }

    public boolean isEmpty() { return size == 0; }
    public int size()        { return size; }
    public int capacity()    { return a.length; }

    private void resize(int capacity) {
        a = Arrays.copyOf(a, capacity);
    }
}
