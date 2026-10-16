public class Mistake3 {
    static int leaves(IntNode t) {
        if (t == null) return 0;
        if (t.left == null || t.right == null) return 1;   // should be &&
        return leaves(t.left) + leaves(t.right);
    }

    public static void main(String[] args) {
        IntNode root = new IntNode(8);
        root.left = new IntNode(3);
        root.right = new IntNode(10);
        root.left.left = new IntNode(1);
        root.left.right = new IntNode(6);
        root.right.right = new IntNode(14);

        root.right.right.left = new IntNode(12);
        root.right.right.right = new IntNode(16);
        System.out.println("leaves: " + leaves(root) + "  (expected 4: 1, 6, 12, 16)");
    }
}
