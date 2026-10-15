import java.util.Arrays;

/** A growing stack of primitive int: no boxing. */
public class IntArrayStack {
    private int[] a = new int[16];
    private int size;

    public void push(int x) {
        if (size == a.length) a = Arrays.copyOf(a, 2 * a.length);
        a[size++] = x;
    }

    public int pop() {
        if (size == 0) throw new IllegalStateException("stack underflow");
        return a[--size];
    }

    public boolean isEmpty() { return size == 0; }
    public int size()        { return size; }
}
