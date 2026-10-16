/** A node of a binary tree holding a value of type T. */
public class Node<T> {
    T value;
    Node<T> left, right;

    Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    static <T> Node<T> leaf(T value) { return new Node<>(value, null, null); }

    /** the example tree of these slides */
    static Node<String> example() {
        return new Node<>("A",
                   new Node<>("B", leaf("D"), leaf("E")),
                   new Node<>("C", null, new Node<>("F", leaf("G"), null)));
    }
}
