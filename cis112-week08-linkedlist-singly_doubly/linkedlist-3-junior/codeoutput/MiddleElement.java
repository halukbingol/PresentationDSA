public class MiddleElement {
    static class Node { final int item; Node next;
        Node(int item, Node next) { this.item = item; this.next = next; } }

    static Node middle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        System.out.println("middle: " + middle(head).item);
    }
}
