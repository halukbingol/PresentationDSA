public interface DequeADT<T> {
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    boolean isEmpty();
}
