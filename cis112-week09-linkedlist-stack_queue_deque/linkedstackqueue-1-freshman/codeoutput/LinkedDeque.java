public class LinkedDeque {
    private Node head;
    private Node tail;

    public void addFirst(int x) {
        Node n = new Node(x);
        if (head == null) { head = tail = n; return; }
        n.next = head;
        head = n;
    }
    public void addLast(int x) {
        Node n = new Node(x);
        if (tail == null) { head = tail = n; return; }
        tail.next = n;
        tail = n;
    }
    public int removeFirst() {
        if (head == null) throw new RuntimeException("Deque underflow");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        return val;
    }
    public static void main(String[] args) {
        LinkedDeque d = new LinkedDeque();
        d.addLast(20); d.addFirst(10); d.addLast(30);
        System.out.println(d.removeFirst());
        System.out.println(d.removeFirst());
    }
}
