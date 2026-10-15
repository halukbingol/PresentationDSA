import java.util.concurrent.atomic.AtomicLong;

public class TreiberTest {
    public static void main(String[] args) throws InterruptedException {
        TreiberStack<Integer> s = new TreiberStack<>();
        AtomicLong poppedSum = new AtomicLong();
        Thread[] ts = new Thread[8];
        for (int t = 0; t < 8; t++) {
            final int id = t;
            ts[t] = new Thread(() -> {
                for (int i = 1; i <= 100_000; i++) {
                    s.push(i);
                    if (id % 2 == 0) {                         // half the threads also pop
                        Integer x = s.pop();
                        if (x != null) poppedSum.addAndGet(x);
                    }
                }
            });
            ts[t].start();
        }
        for (Thread t : ts) t.join();
        long rest = 0;
        for (Integer x; (x = s.pop()) != null; ) rest += x;
        long expected = 8L * 100_000 * 100_001 / 2;
        System.out.printf("sum pushed %,d%nsum popped + left %,d%n%s%n",
                          expected, poppedSum.get() + rest,
                          expected == poppedSum.get() + rest ? "nothing lost" : "LOST ELEMENTS");
    }
}
