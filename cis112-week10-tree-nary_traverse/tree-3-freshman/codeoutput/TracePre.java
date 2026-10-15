public class TracePre {
    static void preorder(IntNode t, String indent) {
        if (t == null) {
            System.out.println(indent + "null: return");
            return;
        }
        System.out.println(indent + "visit " + t.value);
        preorder(t.left, indent + "  ");
        preorder(t.right, indent + "  ");
    }

    public static void main(String[] args) {
        IntNode root = new IntNode(8);
        root.left = new IntNode(3);
        root.right = new IntNode(10);
        preorder(root, "");
    }
}
