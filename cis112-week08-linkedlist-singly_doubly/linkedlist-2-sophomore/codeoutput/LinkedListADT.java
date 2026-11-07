public interface LinkedListADT<T> {
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    boolean contains(T item);
    boolean isEmpty();
    int size();
}
