/** A node of a binary tree. */
public class Node {
    String value;
    Node left, right;               // null: no child

    Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    Node(String value) {            // a leaf
        this(value, null, null);
    }
}
