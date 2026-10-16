public class Recursion {
    static int size(IntNode t) {
        if (t == null) return 0;                      // empty tree: no nodes
        return 1 + size(t.left) + size(t.right);      // me + left + right
    }

    static int sum(IntNode t) {
        if (t == null) return 0;
        return t.value + sum(t.left) + sum(t.right);
    }

    static int max(IntNode t) {                       // t must not be null
        int m = t.value;
        if (t.left != null)  m = Math.max(m, max(t.left));
        if (t.right != null) m = Math.max(m, max(t.right));
        return m;
    }

    public static void main(String[] args) {
        IntNode root = new IntNode(8);
        root.left = new IntNode(3);
        root.right = new IntNode(10);
        root.left.left = new IntNode(1);
        root.left.right = new IntNode(6);
        root.right.right = new IntNode(14);

        System.out.println("size " + size(root));
        System.out.println("sum  " + sum(root));
        System.out.println("max  " + max(root));
    }
}
