public class NodeChain {

    static class Node {
        final int item; 
        final Node next;

        Node(int item, Node next) { 
            this.item = item; 
	    this.next = next; 
        }
    }

    public static void main(String[] args) {

        Node third = new Node(30, null);
        Node second = new Node(20, third);
        Node first  = new Node(10, second);

        for (Node p = first; p != null; p = p.next)
            System.out.println(p.item);
    }
}
