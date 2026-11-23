public class TraceCost {
	static final int N = 100_000;

	public static void main(String[] args) {
		for (int round = 1; round <= 2; round++) {          // round 1 warms up the JIT
			for (int depth : new int[] {1, 100, 1000}) {
				long t0 = System.nanoTime();
				for (int i = 0; i < N; i++) {
					at(depth, true);
				}
				long t1 = System.nanoTime();
				for (int i = 0; i < N; i++) {
					at(depth, false);
				}
				long t2 = System.nanoTime();
				if (round == 2) {
					System.out.printf("depth %4d: %6d ns with a trace, %4d ns without%n",
							depth, (t1 - t0) / N, (t2 - t1) / N);
				}
			}
		}
	}

	/** Calls itself depth times, then creates an exception there. */
	static RuntimeException at(int depth, boolean trace) {
		if (depth > 1) {
			return at(depth - 1, trace);
		}
		return new RuntimeException("here", null, false, trace) { };
	}
}
