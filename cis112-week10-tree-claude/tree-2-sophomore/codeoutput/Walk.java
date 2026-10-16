import java.util.*;
import java.util.function.Consumer;

/** Traversals that call visit for every node. */
public class Walk {
    static <T> void preorder(Node<T> t, Consumer<T> visit) {
        if (t == null) return;
        visit.accept(t.value);
        preorder(t.left, visit);
        preorder(t.right, visit);
    }

    static <T> void inorder(Node<T> t, Consumer<T> visit) {
        if (t == null) return;
        inorder(t.left, visit);
        visit.accept(t.value);
        inorder(t.right, visit);
    }

    static <T> void postorder(Node<T> t, Consumer<T> visit) {
        if (t == null) return;
        postorder(t.left, visit);
        postorder(t.right, visit);
        visit.accept(t.value);
    }

    static <T> List<T> toList(Node<T> t, String order) {
        List<T> out = new ArrayList<>();
        switch (order) {
            case "pre"  -> preorder(t, out::add);
            case "in"   -> inorder(t, out::add);
            default     -> postorder(t, out::add);
        }
        return out;
    }
}
