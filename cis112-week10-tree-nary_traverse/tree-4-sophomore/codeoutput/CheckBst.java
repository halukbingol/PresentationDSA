public class CheckBst {
    static boolean localCheck(Node<Integer> t) {          // WRONG: only parent and children
        if (t == null) return true;
        if (t.left != null && t.left.value > t.value) return false;
        if (t.right != null && t.right.value < t.value) return false;
        return localCheck(t.left) && localCheck(t.right);
    }

    static boolean isBst(Node<Integer> t, long lo, long hi) {   // every key within (lo, hi)
        if (t == null) return true;
        if (t.value <= lo || t.value >= hi) return false;
        return isBst(t.left, lo, t.value) && isBst(t.right, t.value, hi);
    }

    public static void main(String[] args) {
        Node<Integer> t = new Node<>(50,
                              new Node<>(30, Node.leaf(20), Node.leaf(60)),   // 60 > 50!
                              Node.leaf(70));
        System.out.println("local check: " + localCheck(t));
        System.out.println("with bounds: " + isBst(t, Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println("inorder:     " + Walk.toList(t, "in"));
    }
}
