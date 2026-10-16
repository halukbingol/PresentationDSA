import java.util.*;
import java.util.function.BiConsumer;

/** A node of an N-ary tree. */
public class TreeNode<T> {
    final T value;
    final List<TreeNode<T>> children = new ArrayList<>();

    TreeNode(T value) { this.value = value; }

    TreeNode<T> add(TreeNode<T> child) { children.add(child); return this; }

    /** preorder; visit gets the node and its depth */
    void preorder(int depth, BiConsumer<TreeNode<T>, Integer> visit) {
        visit.accept(this, depth);
        for (TreeNode<T> c : children) c.preorder(depth + 1, visit);
    }

    int height() {
        int h = -1;
        for (TreeNode<T> c : children) h = Math.max(h, c.height());
        return h + 1;
    }

    int size() {
        int n = 1;
        for (TreeNode<T> c : children) n += c.size();
        return n;
    }
}
