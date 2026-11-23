public class Bug2 {
    static class Node {
        final int item; Node next;
        Node(int item) { this.item = item; }
    }
    static Node head, tail;
    static void enqueue(int x) {
        Node n = new Node(x);
        if (tail == null) head = tail = n;
        else { tail.next = n; tail = n; }
    }
    static int dequeue() {
        int x = head.item;
        head = head.next;
        // BUG: forgot: if (head == null) tail = null;
        return x;
    }
    public static void main(String[] args) {
        enqueue(1);
        dequeue();
        enqueue(2);       // attached to a stale tail
        System.out.println("head null? " + (head == null));
        System.out.println("tail.item = " + tail.item);
    }
}
