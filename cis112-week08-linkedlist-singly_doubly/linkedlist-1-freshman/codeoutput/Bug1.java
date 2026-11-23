public class Bug1 {
    static class Node {
        final int item; final Node next;
        Node(int item, Node next) { this.item = item; this.next = next; }
    }
    static Node top;
    static int pop() {
        // BUG: no null check
        int x = top.item;
        top = top.next;
        return x;
    }
    public static void main(String[] args) {
        pop();
    }
}
