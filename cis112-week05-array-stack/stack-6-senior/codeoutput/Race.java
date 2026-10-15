import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.IntConsumer;

public class Race {
    static int[] a = new int[400_000];
    static int size;                                  // shared, not protected
    static void unsafePush(int x) { a[size++] = x; }

    static void run4(IntConsumer push) throws InterruptedException {
        Thread[] ts = new Thread[4];
        for (int t = 0; t < 4; t++) {
            ts[t] = new Thread(() -> { for (int i = 0; i < 100_000; i++) push.accept(i); });
            ts[t].start();
        }
        for (Thread t : ts) t.join();
    }

    public static void main(String[] args) throws InterruptedException {
        run4(Race::unsafePush);
        System.out.printf("unsynchronized array stack: %,7d elements%n", size);

        Stack<Integer> st = new Stack<>();
        run4(st::push);
        System.out.printf("java.util.Stack:            %,7d elements%n", st.size());

        ConcurrentLinkedDeque<Integer> cd = new ConcurrentLinkedDeque<>();
        run4(cd::push);
        System.out.printf("ConcurrentLinkedDeque:      %,7d elements%n", cd.size());
    }
}
