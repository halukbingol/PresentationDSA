import java.util.*;
public class QueueTwoStacks<T> {
    private final Stack<T> in  = newStack<>();
    private final Stack<T> out = new Stack<>();
    public void enqueue(T x) { in.push(x); }
    public T dequeue() {
        if (out.isEmpty())
            while (!in.isEmpty()) out.push(in.pop());
        return out.pop();
    }
    public boolean isEmpty() { return in.isEmpty() && out.isEmpty();}
    public static void main(String[] args) {
        QueueTwoStacks<String> q = new QueueTwoStacks<>();
        q.enqueue("A"); q.enqueue("B"); q.enqueue("C");
        System.out.println(q.dequeue());   // A
        System.out.println(q.dequeue());   // B
        q.enqueue("D");
        System.out.println(q.dequeue());   // C
        System.out.println(q.dequeue());   // D
        System.out.println(q.isEmpty());   // true
    }
}