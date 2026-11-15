import java.util.ArrayDeque;
import java.util.Deque;

public class Josephus {
    static int solve(int n, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) q.addLast(i);
        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                q.addLast(q.removeFirst());
            }
            q.removeFirst();
        }
        return q.removeFirst();
    }
    public static void main(String[] args) {
        System.out.println("Survivor: " + solve(7, 3));
    }
}
