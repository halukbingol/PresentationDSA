public class Bst {
    static Node insert(Node t, String v) {          // returns the new root of this subtree
        if (t == null) return new Node(v);
        if (v.compareTo(t.value) < 0) t.left = insert(t.left, v);
        else if (v.compareTo(t.value) > 0) t.right = insert(t.right, v);
        return t;                                    // equal: already there
    }

    static boolean contains(Node t, String v) {
        System.out.print(" " + (t == null ? "null" : t.value));
        if (t == null) return false;
        int c = v.compareTo(t.value);
        return c == 0 || contains(c < 0 ? t.left : t.right, v);
    }

    static void inorder(Node t) {
        if (t == null) return;
        inorder(t.left);
        System.out.print(t.value + " ");
        inorder(t.right);
    }

    static void sideways(Node t, String indent) {   // right subtree on top
        if (t == null) return;
        sideways(t.right, indent + "    ");
        System.out.println(indent + t.value);
        sideways(t.left, indent + "    ");
    }

    public static void main(String[] args) {
        Node root = null;
        for (String w : "mango fig pear apple kiwi plum banana".split(" ")) root = insert(root, w);
        sideways(root, "");
        System.out.print("inorder: ");
        inorder(root);
        System.out.print("\nsearch kiwi:");
        System.out.println("  -> " + contains(root, "kiwi"));
        System.out.print("search lime:");
        System.out.println("  -> " + contains(root, "lime"));
    }
}
