public class ThreeOrders {
    static void pre(IntNode t) {
        if (t == null) return;
        System.out.print(t.value + " ");
        pre(t.left);
        pre(t.right);
    }

    static void in(IntNode t) {
        if (t == null) return;
        in(t.left);
        System.out.print(t.value + " ");
        in(t.right);
    }

    static void post(IntNode t) {
        if (t == null) return;
        post(t.left);
        post(t.right);
        System.out.print(t.value + " ");
    }

    public static void main(String[] args) {
        IntNode root = new IntNode(8);
        root.left = new IntNode(3);
        root.right = new IntNode(10);
        root.left.left = new IntNode(1);
        root.left.right = new IntNode(6);
        root.right.right = new IntNode(14);

        System.out.print("preorder:  "); pre(root);  System.out.println();
        System.out.print("inorder:   "); in(root);   System.out.println();
        System.out.print("postorder: "); post(root); System.out.println();
    }
}
