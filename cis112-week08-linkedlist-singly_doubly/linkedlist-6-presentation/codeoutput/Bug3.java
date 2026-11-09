public class Bug3 {
    static class Node {
        final int item; Node next;
        Node(int item) { this.item = item; }
    }
    static Node first;
    static void insertFirstWrong(int x) {
        Node n = new Node(x);
        first = n;             // BUG: reassign before linking
        n.next = first;        // n.next = n
    }
    public static void main(String[] args) {
        insertFirstWrong(1);
        insertFirstWrong(2);
        System.out.println("first.item = " + first.item);
        System.out.println("first.next == first? " + (first.next == first));
    }
}
