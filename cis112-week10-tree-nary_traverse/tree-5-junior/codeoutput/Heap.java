import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : new int[] {50, 30, 70, 20, 40, 10, 60}) pq.add(x);
        System.out.println("internal array: " + pq);     // toString shows the array
        System.out.print("poll in order:  ");
        while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
        System.out.println();
    }
}
