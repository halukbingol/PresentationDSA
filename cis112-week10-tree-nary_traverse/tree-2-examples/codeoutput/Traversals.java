import java.util.ArrayDeque;
import java.util.Queue;

public class Traversals {
    static void preorder(Node t) {
        if (t == null) return;
        System.out.print(t.value + " ");
        preorder(t.left);
        preorder(t.right);
    }

    static void inorder(Node t) {
        if (t == null) return;
        inorder(t.left);
        System.out.print(t.value + " ");
        inorder(t.right);
    }

    static void postorder(Node t) {
        if (t == null) return;
        postorder(t.left);
        postorder(t.right);
        System.out.print(t.value + " ");
    }

    static void levelOrder(Node t) {
        Queue<Node> q = new ArrayDeque<>();
        if (t != null) q.add(t);
        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.value + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node("A",
                        new Node("B", new Node("D"), new Node("E")),
                        new Node("C", null, new Node("F", new Node("G"), null)));
        System.out.print("preorder:    "); preorder(root);   System.out.println();
        System.out.print("inorder:     "); inorder(root);    System.out.println();
        System.out.print("postorder:   "); postorder(root);  System.out.println();
        System.out.print("level order: "); levelOrder(root); System.out.println();
    }
}
