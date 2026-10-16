public class Build {
    public static void main(String[] args) {
        IntNode root = new IntNode(8);     // 1. make the nodes
        IntNode a = new IntNode(3);
        IntNode b = new IntNode(10);
        IntNode c = new IntNode(1);
        IntNode e = new IntNode(6);
        IntNode f = new IntNode(14);

        root.left = a;                     // 2. link them
        root.right = b;
        a.left = c;
        a.right = e;
        b.right = f;

        System.out.println("root:            " + root.value);
        System.out.println("root.left:       " + root.left.value);
        System.out.println("root.right:      " + root.right.value);
        System.out.println("root.left.right: " + root.left.right.value);
        System.out.println("root.right.left: " + root.right.left);
    }
}
