public class LinkedStack {
    private Node top;

    public void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("Stack underflow");
        int val = top.data;
        top = top.next;
        return val;
    }

    public boolean isEmpty() { return top == null; }

    public static void main(String[] args) {
        LinkedStack s = new LinkedStack();
        s.push(10); s.push(20); s.push(30);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
