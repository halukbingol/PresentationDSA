import java.util.Arrays;
import java.util.Random;

/** Selection sort is O(n^2); Arrays.sort is O(n log n). */
public class SortGrowth {
	static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;        // smallest so far
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[i];    // swap it to i
			a[i] = a[min];
			a[min] = temp;
		}
	}

	static double millis(int[] a, boolean library) {   // best of 3
		double best = Double.MAX_VALUE;
		for (int run = 0; run < 3; run++) {
			int[] copy = Arrays.copyOf(a, a.length);
			long start = System.nanoTime();
			if (library) {
				Arrays.sort(copy);
			} else {
				selectionSort(copy);
			}
			best = Math.min(best, (System.nanoTime() - start) / 1e6);
		}
		return best;
	}

	public static void main(String[] args) {
		Random random = new Random(111);
		for (int k = 0; k < 5; k++) {           // warm up the JIT
			millis(random.ints(20_000).toArray(), false);
			millis(random.ints(20_000).toArray(), true);
		}
		System.out.printf("%8s %14s %12s%n", "n", "selection ms", "Arrays.sort");
		for (int n = 10_000; n <= 80_000; n *= 2) {
			int[] a = random.ints(n).toArray();
			System.out.printf("%,8d %14.1f %12.2f%n",
					n, millis(a, false), millis(a, true));
		}
	}
}
