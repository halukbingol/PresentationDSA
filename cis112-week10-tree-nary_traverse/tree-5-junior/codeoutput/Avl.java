/** An AVL tree: for every node the heights of the two subtrees differ by at most 1. */
public class Avl {
    static final class Node {
        int key, height;                         // height of a leaf: 0
        Node left, right;
        Node(int k) { key = k; }
    }
    Node root;
    int rotations;

    static int h(Node n) { return n == null ? -1 : n.height; }
    static void fix(Node n) { n.height = 1 + Math.max(h(n.left), h(n.right)); }

    Node rotateRight(Node y) {                   // y.left goes up
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        fix(y); fix(x); rotations++;
        return x;
    }

    Node rotateLeft(Node x) {                    // x.right goes up
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        fix(x); fix(y); rotations++;
        return y;
    }

    void insert(int k) { root = insert(root, k); }

    Node insert(Node t, int k) {
        if (t == null) return new Node(k);
        if (k < t.key) t.left = insert(t.left, k);
        else if (k > t.key) t.right = insert(t.right, k);
        else return t;
        fix(t);
        int bal = h(t.left) - h(t.right);
        if (bal > 1) {                                       // left too high
            if (k > t.left.key) t.left = rotateLeft(t.left);  // left-right case
            return rotateRight(t);
        }
        if (bal < -1) {                                      // right too high
            if (k < t.right.key) t.right = rotateRight(t.right);
            return rotateLeft(t);
        }
        return t;
    }

    String sideways() { StringBuilder sb = new StringBuilder(); sideways(root, "", sb); return sb.toString(); }

    void sideways(Node t, String ind, StringBuilder sb) {
        if (t == null) return;
        sideways(t.right, ind + "   ", sb);
        sb.append(ind).append(t.key).append('\n');
        sideways(t.left, ind + "   ", sb);
    }
}
