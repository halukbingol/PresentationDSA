public class Deep {
    static final class Node { int key; Node left, right; Node(int k) { key = k; } }
    static long sum;

    static void inorderRecursive(Node t) {
        if (t == null) return;
        inorderRecursive(t.left);
        sum += t.key;
        inorderRecursive(t.right);
    }

    static void inorderMorris(Node t) {               // O(1) extra memory
        while (t != null) {
            if (t.left == null) { sum += t.key; t = t.right; continue; }
            Node p = t.left;
            while (p.right != null && p.right != t) p = p.right;   // predecessor
            if (p.right == null) { p.right = t; t = t.left; }      // thread to t
            else { p.right = null; sum += t.key; t = t.right; }    // remove thread
        }
    }

    public static void main(String[] args) {
        Node root = null;                             // a degenerate tree: 1 .. n
        for (int k = 1_000_000; k >= 1; k--) { Node n = new Node(k); n.right = root; root = n; }
        sum = 0; inorderMorris(root);
        System.out.println("Morris:    sum = " + sum);
        sum = 0; inorderRecursive(root);
        System.out.println("recursive: sum = " + sum);
    }
}
