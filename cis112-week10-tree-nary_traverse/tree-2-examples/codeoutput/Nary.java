import java.util.ArrayList;
import java.util.List;

public class Nary {
    static class TreeNode {
        String name;
        List<TreeNode> children = new ArrayList<>();

        TreeNode(String name, TreeNode... kids) {
            this.name = name;
            children.addAll(List.of(kids));
        }
    }

    static void outline(TreeNode n, String indent) {         // preorder
        System.out.println(indent + n.name);
        for (TreeNode c : n.children) outline(c, indent + "  ");
    }

    static void postorder(TreeNode n) {
        for (TreeNode c : n.children) postorder(c);
        System.out.print(n.name + " ");
    }

    static int height(TreeNode n) {
        int h = -1;
        for (TreeNode c : n.children) h = Math.max(h, height(c));
        return h + 1;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode("R",
            new TreeNode("A", new TreeNode("D"), new TreeNode("E")),
            new TreeNode("B"),
            new TreeNode("C", new TreeNode("F"), new TreeNode("G"), new TreeNode("H")));
        outline(r, "");
        System.out.print("postorder: ");
        postorder(r);
        System.out.println();
        System.out.println("height: " + height(r) + ", children of the root: " + r.children.size());
    }
}
