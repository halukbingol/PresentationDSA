public class Deep {
    static final class Node {               // a list of n nodes: a "path"
        final Node next;
        Node(Node next) { this.next = next; }
    }

    static int lengthRecursive(Node n) {
        return n == null ? 0 : 1 + lengthRecursive(n.next);
    }

    static int lengthWithStack(Node n) {    // the same walk, our own stack
        java.util.ArrayDeque<Node> stack = new java.util.ArrayDeque<>();
        for (Node p = n; p != null; p = p.next) stack.push(p);
        int length = 0;
        while (!stack.isEmpty()) { stack.pop(); length++; }
        return length;
    }

    public static void main(String[] args) {
        Node list = null;
        for (int i = 0; i < 1_000_000; i++) list = new Node(list);
        System.out.println("with a stack: " + lengthWithStack(list));
        System.out.println("recursive:    " + lengthRecursive(list));
    }
}
