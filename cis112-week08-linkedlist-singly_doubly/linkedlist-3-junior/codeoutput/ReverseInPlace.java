public class ReverseInPlace {
    static class Node { final int item; Node next;
        Node(int item, Node next) { this.item = item; this.next = next; } }

    static Node reverse(Node head) {
        Node prev = null, cur = head;
        while (cur != null) {
            Node n = cur.next;
            cur.next = prev;
            prev = cur;
            cur = n;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        head = reverse(head);
        for (Node p = head; p != null; p = p.next) System.out.print(p.item + " ");
        System.out.println();
    }
}
