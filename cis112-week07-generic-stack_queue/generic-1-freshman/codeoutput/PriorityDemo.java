import java.util.*;

public class PriorityDemo {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        System.out.println(pq.poll());   // 10 (smallest first)
        System.out.println(pq.poll());   // 20
        System.out.println(pq.poll());   // 30
    }
}