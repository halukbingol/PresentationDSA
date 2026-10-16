public class Measures {
    static int size(Node t) {
        return t == null ? 0 : 1 + size(t.left) + size(t.right);
    }

    static int height(Node t) {             // empty tree: -1
        return t == null ? -1 : 1 + Math.max(height(t.left), height(t.right));
    }

    static int leaves(Node t) {
        if (t == null) return 0;
        if (t.left == null && t.right == null) return 1;
        return leaves(t.left) + leaves(t.right);
    }

    static int depth(Node t, String v, int d) {   // -1: not found
        if (t == null) return -1;
        if (t.value.equals(v)) return d;
        int l = depth(t.left, v, d + 1);
        return l >= 0 ? l : depth(t.right, v, d + 1);
    }

    public static void main(String[] args) {
        Node root = new Node("A",
                        new Node("B", new Node("D"), new Node("E")),
                        new Node("C", null, new Node("F", new Node("G"), null)));
        System.out.println("size     " + size(root));
        System.out.println("height   " + height(root));
        System.out.println("leaves   " + leaves(root));
        System.out.println("depth(G) " + depth(root, "G", 0));
        System.out.println("depth(X) " + depth(root, "X", 0));
        System.out.println("height of the empty tree " + height(null));
    }
}
