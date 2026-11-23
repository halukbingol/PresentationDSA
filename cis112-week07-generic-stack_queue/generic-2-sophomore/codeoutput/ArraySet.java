import java.util.NoSuchElementException;

public class ArraySet<T> implements SetADT<T> {
    private T[] a;
    private int n;   // number of elements; all elements at 0..n-1, no holes

    @SuppressWarnings("unchecked")
    public ArraySet(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("capacity < 1");
        a = (T[]) new Object[capacity];
        n = 0;
    }

    public boolean add(T item) {
        if (item == null) throw new NullPointerException("null not allowed");
        if (contains(item)) return false;               // already there
        if (n == a.length) grow();
        a[n++] = item;
        return true;
    }

    public boolean contains(T item) {
        for (int i = 0; i < n; i++) if (a[i].equals(item)) return true;
        return false;
    }

    public boolean remove(T item) {
        for (int i = 0; i < n; i++) {
            if (a[i].equals(item)) {
                a[i] = a[n - 1];   // fill the hole with the last element
                a[--n] = null;     // and clear the last slot
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() { return n == 0; }
    public int size() { return n; }

    @SuppressWarnings("unchecked")
    private void grow() {
        T[] b = (T[]) new Object[a.length * 2];
        System.arraycopy(a, 0, b, 0, n);
        a = b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < n; i++) {
            sb.append(a[i]);
            if (i < n - 1) sb.append(", ");
        }
        return sb.append("}").toString();
    }
}