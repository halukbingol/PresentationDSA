public class TestQueue {
    public static void main(String[] args) {
        ArrayQueue<String> q = new ArrayQueue<>(3);
        q.enqueue("A"); System.out.println(q);
        q.enqueue("B"); System.out.println(q);
        q.enqueue("C"); System.out.println(q);
        System.out.println("dequeue = " + q.dequeue());
        System.out.println("after      " + q);
        q.enqueue("D"); System.out.println(q);   // wrap
        q.enqueue("E"); System.out.println(q);   // grow
        while (!q.isEmpty()) System.out.println("dequeue = " + q.dequeue());
    }
}