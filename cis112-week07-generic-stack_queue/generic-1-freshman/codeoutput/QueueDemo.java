import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(10);
        q.offer(20);
        System.out.println(q);           // [10, 20]
        System.out.println(q.peek());    // 10
        System.out.println(q.poll());    // 10
        System.out.println(q.poll());    // 20
        System.out.println(q.poll());    // null
    }
}