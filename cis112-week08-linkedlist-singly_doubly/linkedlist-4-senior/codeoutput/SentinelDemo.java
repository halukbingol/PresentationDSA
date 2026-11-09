public class SentinelDemo {
    static class Node {
        Integer item; Node next;
        Node(Integer item) { this.item = item; }
    }

    static Node head = new Node(null); // sentinel
    static void add(int x) {
        Node n = new Node(x);
        n.next = head.next; head.next = n;
    }
    static void print() {
        for (Node p = head.next; p != null; p = p.next) System.out.print(p.item + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        add(1); add(2); add(3);
        print();
    }
}
