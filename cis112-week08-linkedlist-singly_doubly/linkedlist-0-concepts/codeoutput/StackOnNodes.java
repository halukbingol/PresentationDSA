public class StackOnNodes {

    static class Node { final int item; final Node next;

        Node(int item, Node next) { 
             this.item = item; 
             this.next = next; 
        } 
    }
    Node top;

    void push(int x) { top = new Node(x, top); }

    int pop() {
        if (top == null) throw new RuntimeException("underflow");
        int x = top.item; top = top.next; return x;
    }

    boolean isEmpty() { return top == null; }

    public static void main(String[] args) {
        StackOnNodes s = new StackOnNodes();
        s.push(1); s.push(2); s.push(3);
        while (!s.isEmpty()) System.out.println(s.pop());
    }
}
