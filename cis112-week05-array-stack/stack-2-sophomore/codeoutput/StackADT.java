/** The stack ADT: what every stack can do. */
public interface StackADT<T> extends Iterable<T> {
    void push(T x);
    T pop();          // throws StackUnderflowException when empty
    T peek();         // throws StackUnderflowException when empty
    boolean isEmpty();
    int size();
}
