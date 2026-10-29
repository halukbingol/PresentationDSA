import java.util.concurrent.atomic.AtomicIntegerArray;

/** Four threads add 1 to the same element a million times each. */
public class LostUpdates {
	public static void main(String[] args) throws InterruptedException {
		int[] plain = new int[1];
		AtomicIntegerArray atomic = new AtomicIntegerArray(1);
		Thread[] threads = new Thread[4];
		for (int t = 0; t < threads.length; t++) {
			threads[t] = new Thread(() -> {
				for (int i = 0; i < 1_000_000; i++) {
					plain[0]++;              // read, add, write
					atomic.incrementAndGet(0);
				}
			});
			threads[t].start();
		}
		for (Thread th : threads) {
			th.join();
		}
		System.out.println("expected 4000000");
		System.out.println("int[]              " + plain[0]);
		System.out.println("AtomicIntegerArray " + atomic.get(0));
	}
}
