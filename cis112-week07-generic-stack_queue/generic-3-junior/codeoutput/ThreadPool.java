import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 4; i++) {
            final int n = i;
            pool.submit(() ->
                System.out.println("job " + n + " on " + Thread.currentThread().getName()));
        }
        pool.shutdown();
    }
}