import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BenchArrayVsLinked {
    static final int N = 1_000_000;
    public static void main(String[] args) {
        long t0 = System.nanoTime();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) a.add(i);
        long sum = 0;
        for (int i = 0; i < N; i++) sum += a.get(i);
        long t1 = System.nanoTime();

        List<Integer> l = new LinkedList<>();
        long t2 = System.nanoTime();
        for (int i = 0; i < N; i++) l.add(i);
        long sum2 = 0;
        for (int i = 0; i < N; i++) sum2 += l.get(i);
        long t3 = System.nanoTime();

        System.out.printf("ArrayList  get(): %4d ms (sum %d)%n", (t1 - t0) / 1_000_000, sum);
        System.out.printf("LinkedList get(): %4d ms (sum %d)%n", (t3 - t2) / 1_000_000, sum2);
    }
}
