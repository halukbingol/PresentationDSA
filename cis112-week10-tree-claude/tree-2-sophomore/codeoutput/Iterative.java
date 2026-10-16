import java.util.*;

public class Iterative {
    static <T> List<T> preorder(Node<T> root) {
        List<T> out = new ArrayList<>();
        Deque<Node<T>> stack = new ArrayDeque<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> n = stack.pop();
            out.add(n.value);
            if (n.right != null) stack.push(n.right);     // right first,
            if (n.left != null) stack.push(n.left);       // so left is popped first
        }
        return out;
    }

    static <T> List<T> inorder(Node<T> root) {
        List<T> out = new ArrayList<>();
        Deque<Node<T>> stack = new ArrayDeque<>();
        Node<T> n = root;
        while (n != null || !stack.isEmpty()) {
            while (n != null) { stack.push(n); n = n.left; }   // go left as far as possible
            n = stack.pop();
            out.add(n.value);
            n = n.right;                                       // then the right subtree
        }
        return out;
    }

    static <T> List<List<T>> levels(Node<T> root) {
        List<List<T>> out = new ArrayList<>();
        Queue<Node<T>> q = new ArrayDeque<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            List<T> level = new ArrayList<>();
            for (int k = q.size(); k > 0; k--) {               // exactly one level
                Node<T> n = q.remove();
                level.add(n.value);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            out.add(level);
        }
        return out;
    }

    public static void main(String[] args) {
        Node<String> t = Node.example();
        System.out.println("preorder  " + preorder(t) + "  same as recursive: " + preorder(t).equals(Walk.toList(t, "pre")));
        System.out.println("inorder   " + inorder(t) + "  same as recursive: " + inorder(t).equals(Walk.toList(t, "in")));
        System.out.println("levels    " + levels(t));
    }
}
