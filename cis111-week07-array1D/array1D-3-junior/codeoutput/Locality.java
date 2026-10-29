/** The same work in a different order: neighbors are cheap. */
public class Locality {
	static long sumWithStride(int[] a, int stride) {
		long sum = 0;
		for (int start = 0; start < stride; start++) {
			for (int i = start; i < a.length; i += stride) {
				sum += a[i];                 // every element once
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] a = new int[1 << 24];          // 16 M ints, 64 MB
		for (int i = 0; i < a.length; i++) {
			a[i] = i % 100;
		}
		for (int round = 1; round <= 3; round++) {   // round 3 counts
			for (int stride : new int[] {1, 16, 4096}) {
				long start = System.nanoTime();
				long sum = sumWithStride(a, stride);
				long ms = (System.nanoTime() - start) / 1_000_000;
				if (round == 3) {
					System.out.printf("stride %5d: %4d ms (sum %d)%n",
							stride, ms, sum);
				}
			}
		}
	}
}
