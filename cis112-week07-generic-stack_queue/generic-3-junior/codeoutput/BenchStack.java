import java.util.ArrayDeque;
import java.util.Deque;

public class BenchStack {
    static final int N = 5_000_000;

    public static void main(String[] args) {
        long t0 = System.nanoTime();
        Deque<Integer> s1 = new ArrayDeque<>();
        for (int i = 0; i < N; i++) s1.push(i);
        long sum1 = 0;
        while (!s1.isEmpty()) sum1 += s1.pop();
        long t1 = System.nanoTime();

        LinkedStack<Integer> s2 = new LinkedStack<>();
        long t2 = System.nanoTime();
        for (int i = 0; i < N; i++) s2.push(i);
        long sum2 = 0;
        while (!s2.isEmpty()) sum2 += s2.pop();
        long t3 = System.nanoTime();

        System.out.printf("ArrayDeque : %4d ms  (sum %d)%n", (t1 - t0) / 1_000_000, sum1);
        System.out.printf("LinkedStack: %4d ms  (sum %d)%n", (t3 - t2) / 1_000_000, sum2);
    }
}