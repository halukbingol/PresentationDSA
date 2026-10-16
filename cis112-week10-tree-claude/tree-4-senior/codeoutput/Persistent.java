/** An immutable BST: insert returns a new version and shares what did not change. */
public class Persistent {
    record Node(int key, Node left, Node right) { }

    static Node insert(Node t, int k) {
        if (t == null) return new Node(k, null, null);
        if (k < t.key()) return new Node(t.key(), insert(t.left(), k), t.right());   // copy the path
        if (k > t.key()) return new Node(t.key(), t.left(), insert(t.right(), k));
        return t;
    }

    static int size(Node t) { return t == null ? 0 : 1 + size(t.left()) + size(t.right()); }

    static int shared(Node a, Node b) {           // nodes that are the SAME object in both
        if (a == null || b == null) return 0;
        if (a == b) return size(a);
        return shared(a.left(), b.left()) + shared(a.right(), b.right());
    }

    static String keys(Node t) { return t == null ? "" : keys(t.left()) + t.key() + " " + keys(t.right()); }

    public static void main(String[] args) {
        Node v1 = null;
        for (int k : new int[] {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45}) v1 = insert(v1, k);
        Node v2 = insert(v1, 65);                 // a new version
        System.out.println("v1: " + keys(v1));
        System.out.println("v2: " + keys(v2));
        System.out.println("v2 has " + size(v2) + " nodes, " + shared(v1, v2) + " of them shared with v1");
    }
}
