import java.util.List;

public class Rebuild {
    /** the tree with this preorder and inorder (values must be distinct) */
    static <T> Node<T> build(List<T> pre, List<T> in) {
        if (pre.isEmpty()) return null;
        T root = pre.get(0);
        int k = in.indexOf(root);                      // left subtree has k nodes
        return new Node<>(root,
            build(pre.subList(1, k + 1), in.subList(0, k)),
            build(pre.subList(k + 1, pre.size()), in.subList(k + 1, in.size())));
    }

    public static void main(String[] args) {
        List<String> pre = List.of("A", "B", "D", "E", "C", "F", "G");
        List<String> in  = List.of("D", "B", "E", "A", "C", "G", "F");
        Node<String> t = build(pre, in);
        System.out.println("postorder of the rebuilt tree: " + Walk.toList(t, "post"));
        System.out.println("same as the original:          "
            + Walk.toList(t, "post").equals(Walk.toList(Node.example(), "post")));
    }
}
