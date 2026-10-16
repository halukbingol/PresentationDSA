public class Mistake2 {
    static int size(IntNode t) {
        if (t == null) return 0;
        return 1 + size(t) + size(t.right);           // typo: t instead of t.left
    }

    public static void main(String[] args) {
        IntNode root = new IntNode(8);
        System.out.println(size(root));
    }
}
