public class Mistake1 {
    static int size(IntNode t) {
        return 1 + size(t.left) + size(t.right);      // no check for null
    }

    public static void main(String[] args) {
        IntNode root = new IntNode(8);
        root.left = new IntNode(3);
        System.out.println(size(root));
    }
}
