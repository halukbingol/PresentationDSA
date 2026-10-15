public class UseNary {
    static TreeNode<String> n(String v) { return new TreeNode<>(v); }

    public static void main(String[] args) {
        TreeNode<String> book = n("Book")
            .add(n("1 Trees").add(n("1.1 Terms")).add(n("1.2 Binary trees")))
            .add(n("2 Traversal").add(n("2.1 Depth first")).add(n("2.2 Breadth first"))
                                 .add(n("2.3 N-ary trees")))
            .add(n("3 Exercises"));

        book.preorder(0, (node, depth) ->
            System.out.println("  ".repeat(depth) + node.value
                + (node.children.isEmpty() ? "" : "  (" + node.children.size() + " children)")));
        System.out.println("size " + book.size() + ", height " + book.height());
    }
}
