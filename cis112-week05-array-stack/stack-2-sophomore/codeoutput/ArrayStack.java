import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** A stack in an array that doubles when full and halves when 1/4 full. */
public class ArrayStack<T> implements StackADT<T> {
    private T[] a;
    private int size;                 // the top is a[size - 1]

    @SuppressWarnings("unchecked")
    public ArrayStack() { a = (T[]) new Object[2]; }

    @Override public void push(T x) {
        if (size == a.length) a = Arrays.copyOf(a, 2 * a.length);
        a[size++] = x;
    }

    @Override public T pop() {
        if (isEmpty()) throw new StackUnderflowException("pop");
        T x = a[--size];
        a[size] = null;                   // avoid loitering
        if (size > 0 && size == a.length / 4) a = Arrays.copyOf(a, a.length / 2);
        return x;
    }

    @Override public T peek() {
        if (isEmpty()) throw new StackUnderflowException("peek");
        return a[size - 1];
    }

    @Override public boolean isEmpty() { return size == 0; }
    @Override public int size()        { return size; }

    @Override public Iterator<T> iterator() {      // from the top to the bottom
        return new Iterator<>() {
            private int i = size - 1;
            @Override public boolean hasNext() { return i >= 0; }
            @Override public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return a[i--];
            }
        };
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("top [");
        for (T x : this) sb.append(sb.length() > 5 ? ", " : "").append(x);
        return sb.append("]").toString();
    }
}
