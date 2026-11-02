import java.util.NoSuchElementException;

public class ArrayQueue<T> implements QueueADT<T> {
    private T[] a;
    private int head;   // index of the front element
    private int tail;   // index of the next free slot
    private int size;   // number of elements: resolves empty vs full

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("capacity < 1");
        a = (T[]) new Object[capacity];
        head = tail = size = 0;
    }

    public void enqueue(T item) {
        if (size == a.length) grow();
        a[tail] = item;
        tail = (tail + 1) % a.length;
        size++;
    }

    public T dequeue() {
        if (size == 0) throw new NoSuchElementException("queue underflow");
        T item = a[head];
        a[head] = null;                       // avoid loitering
        head = (head + 1) % a.length;
        size--;
        return item;
    }

    public T peek() {
        if (size == 0) throw new NoSuchElementException("queue underflow");
        return a[head];
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    @SuppressWarnings("unchecked")
    private void grow() {
        T[] b = (T[]) new Object[a.length * 2];
        for (int i = 0; i < size; i++)
            b[i] = a[(head + i) % a.length];   // unwrap: copy in queue order
        a = b;
        head = 0;
        tail = size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(a[(head + i) % a.length]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}