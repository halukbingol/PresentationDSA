public class CycleDetect {
    static class Node { int item; Node next;
        Node(int item) { this.item = item; } }

    static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node a = new Node(1), b = new Node(2), c = new Node(3);
        a.next = b; b.next = c; c.next = a;
        System.out.println("cycle: " + hasCycle(a));
        Node x = new Node(1), y = new Node(2);
        x.next = y;
        System.out.println("cycle: " + hasCycle(x));
    }
}
