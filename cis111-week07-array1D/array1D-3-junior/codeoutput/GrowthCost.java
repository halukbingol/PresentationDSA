/** Element copies needed to add n elements one at a time. */
public class GrowthCost {
	static long copies(int n, boolean doubling) {
		long copies = 0;
		long capacity = 1;
		for (long size = 0; size < n; size++) {
			if (size == capacity) {            // full: grow
				copies += size;                // copy them all
				capacity = doubling ? 2 * capacity : capacity + 1;
			}
		}
		return copies;
	}

	public static void main(String[] args) {
		System.out.printf("%10s %16s %12s%n", "n", "grow +1", "grow x2");
		for (int n = 1_000; n <= 1_000_000; n *= 10) {
			System.out.printf("%,10d %,16d %,12d%n",
					n, copies(n, false), copies(n, true));
		}
	}
}
