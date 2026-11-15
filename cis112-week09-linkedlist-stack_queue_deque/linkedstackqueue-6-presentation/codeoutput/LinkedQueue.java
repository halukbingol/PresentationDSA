public class LinkedQueue {
    private Node head;
    private Node tail;

    public void enqueue(int x) {
        Node n = new Node(x);
        if (tail == null) { head = tail = n; return; }
        tail.next = n;
        tail = n;
    }

    public int dequeue() {
        if (head == null) throw new RuntimeException("Queue underflow");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        return val;
    }

    public boolean isEmpty() { return head == null; }

    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
    }
}
