/** A plain binary search tree of int keys (no balancing). Iterative: no recursion depth limit. */
public class PlainBst {
    static final class Node { int key; Node left, right; Node(int k) { key = k; } }
    Node root;

    void insert(int k) {
        if (root == null) { root = new Node(k); return; }
        Node t = root;
        while (true) {
            if (k < t.key) { if (t.left == null) { t.left = new Node(k); return; } t = t.left; }
            else if (k > t.key) { if (t.right == null) { t.right = new Node(k); return; } t = t.right; }
            else return;
        }
    }

    int height() {                               // level by level, no recursion
        if (root == null) return -1;
        java.util.ArrayDeque<Node> q = new java.util.ArrayDeque<>();
        q.add(root);
        int h = -1;
        while (!q.isEmpty()) {
            h++;
            for (int k = q.size(); k > 0; k--) {
                Node n = q.remove();
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }
        return h;
    }
}
