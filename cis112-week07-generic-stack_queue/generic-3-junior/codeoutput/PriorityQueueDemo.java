import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        int[] nums = {5, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        for (int n : nums) pq.offer(n);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll()).append(' ');
        System.out.println("sorted: " + sb.toString().trim());
    }
}