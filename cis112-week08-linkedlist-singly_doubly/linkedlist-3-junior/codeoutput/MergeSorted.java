public class MergeSorted {
    static class Node { final int item; Node next;
        Node(int item) { this.item = item; } }

    static Node merge(Node a, Node b) {
        Node dummy = new Node(0), t = dummy;
        while (a != null && b != null) {
            if (a.item <= b.item) { t.next = a; a = a.next; }
            else                   { t.next = b; b = b.next; }
            t = t.next;
        }
        t.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node a = new Node(1); a.next = new Node(4);
        Node b = new Node(2); b.next = new Node(3);
        Node m = merge(a, b);
        for (Node p = m; p != null; p = p.next) System.out.print(p.item + " ");
        System.out.println();
    }
}
