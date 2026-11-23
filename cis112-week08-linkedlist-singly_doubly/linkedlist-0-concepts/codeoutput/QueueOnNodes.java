public class QueueOnNodes {
    static class Node { final int item; Node next;
        Node(int item) { this.item = item; } }
    Node head, tail;
    void enqueue(int x) {
        Node n = new Node(x);
        if (tail == null) { head = tail = n; }
        else { tail.next = n; tail = n; }
    }
    int dequeue() {
        if (head == null) throw new RuntimeException("underflow");
        int x = head.item; head = head.next;
        if (head == null) tail = null;
        return x;
    }
    boolean isEmpty() { return head == null; }
    public static void main(String[] args) {
        QueueOnNodes q = new QueueOnNodes();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        while (!q.isEmpty()) System.out.println(q.dequeue());
    }
}
