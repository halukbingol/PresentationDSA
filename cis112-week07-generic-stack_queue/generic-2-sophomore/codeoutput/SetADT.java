public interface SetADT<T> {
    boolean add(T item);      // true if it was new
    boolean remove(T item);   // true if it was present
    boolean contains(T item);
    boolean isEmpty();
    int size();
}