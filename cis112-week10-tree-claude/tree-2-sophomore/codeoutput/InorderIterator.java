import java.util.*;

/** Gives the values in inorder, one at a time: O(h) memory. */
public class InorderIterator<T> implements Iterator<T> {
    private final Deque<Node<T>> stack = new ArrayDeque<>();

    InorderIterator(Node<T> root) { pushLeft(root); }

    private void pushLeft(Node<T> n) {
        for (; n != null; n = n.left) stack.push(n);
    }

    @Override public boolean hasNext() { return !stack.isEmpty(); }

    @Override public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        Node<T> n = stack.pop();
        pushLeft(n.right);
        return n.value;
    }
}
