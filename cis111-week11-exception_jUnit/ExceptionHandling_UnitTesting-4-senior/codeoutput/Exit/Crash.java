public class Crash {
	public static void main(String[] args) {
		Thread worker = new Thread(() -> {
			throw new IllegalStateException("worker failed");
		});
		worker.start();
		try {
			worker.join();                  // wait for it
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("main goes on");
		if (args.length > 0) {
			throw new IllegalArgumentException("main failed");
		}
	}
}
