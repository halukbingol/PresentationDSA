import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(10);
        queue.offer(20);
        System.out.println(queue);          // [10, 20]
        System.out.println(queue.peek());   // 10
        System.out.println(queue.poll());   // 10
        System.out.println(queue.poll());   // 20
        System.out.println(queue.poll());   // null
    }
}