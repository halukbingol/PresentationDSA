public class MorrisTraversal {
    static class Node {
        int item; Node left, right;
        Node(int item) { this.item = item; }
    }

    static void inorder(Node root) {
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.item + " ");
                cur = cur.right;
            } else {
                Node p = cur.left;
                while (p.right != null && p.right != cur) p = p.right;
                if (p.right == null) { p.right = cur; cur = cur.left; }
                else {
                    p.right = null;
                    System.out.print(cur.item + " ");
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2); root.right = new Node(6);
        root.left.left = new Node(1); root.left.right = new Node(3);
        root.right.left = new Node(5); root.right.right = new Node(7);
        System.out.print("in-order: ");
        inorder(root);
    }
}
