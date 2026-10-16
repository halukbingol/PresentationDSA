/** A binary search tree: smaller keys left, larger keys right. */
public class Bst<K extends Comparable<K>> implements Iterable<K> {
    private Node<K> root;

    public void insert(K k) { root = insert(root, k); }

    private Node<K> insert(Node<K> t, K k) {
        if (t == null) return Node.leaf(k);
        int c = k.compareTo(t.value);
        if (c < 0) t.left = insert(t.left, k);
        else if (c > 0) t.right = insert(t.right, k);
        return t;
    }

    public boolean contains(K k) {
        Node<K> t = root;
        while (t != null) {
            int c = k.compareTo(t.value);
            if (c == 0) return true;
            t = c < 0 ? t.left : t.right;
        }
        return false;
    }

    public void delete(K k) { root = delete(root, k); }

    private Node<K> delete(Node<K> t, K k) {
        if (t == null) return null;
        int c = k.compareTo(t.value);
        if (c < 0) t.left = delete(t.left, k);
        else if (c > 0) t.right = delete(t.right, k);
        else if (t.left == null) return t.right;          // 0 or 1 child
        else if (t.right == null) return t.left;
        else {                                            // 2 children
            Node<K> m = t.right;
            while (m.left != null) m = m.left;            // smallest on the right
            t.value = m.value;
            t.right = delete(t.right, m.value);
        }
        return t;
    }

    public java.util.Iterator<K> iterator() { return new InorderIterator<>(root); }

    public String sideways() { StringBuilder sb = new StringBuilder(); sideways(root, "", sb); return sb.toString(); }

    private void sideways(Node<K> t, String indent, StringBuilder sb) {
        if (t == null) return;
        sideways(t.right, indent + "   ", sb);
        sb.append(indent).append(t.value).append('\n');
        sideways(t.left, indent + "   ", sb);
    }
}
