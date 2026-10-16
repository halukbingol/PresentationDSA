import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Virtual {
    static int deep(int n) { return n == 0 ? 0 : 1 + deep(n - 1); }

    public static void main(String[] args) {
        AtomicInteger done = new AtomicInteger();
        long t = System.nanoTime();
        try (var ex = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 100_000; i++) {
                ex.submit(() -> {
                    deep(50);                            // some frames on its stack
                    try { Thread.sleep(Duration.ofMillis(100)); } catch (InterruptedException e) { }
                    done.incrementAndGet();
                });
            }
        }                                                // waits for all tasks
        System.out.printf("%,d virtual threads finished in %d ms%n",
                          done.get(), (System.nanoTime() - t) / 1_000_000);
    }
}
