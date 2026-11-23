import java.util.Arrays;
import java.util.Random;

public class PropertySort {
	public static void main(String[] args) {
		Random random = new Random(1);                // a fixed seed: the same run every time
		for (int run = 1; run <= 1000; run++) {
			int[] a = new int[random.nextInt(6)];
			for (int i = 0; i < a.length; i++) {
				a[i] = random.nextInt(10);
			}
			int[] sorted = a.clone();
			sort(sorted);
			int[] expected = a.clone();
			Arrays.sort(expected);                     // the oracle: a trusted sort
			if (!Arrays.equals(sorted, expected)) {
				System.out.println("run " + run + ": " + Arrays.toString(a)
						+ " gives " + Arrays.toString(sorted));
				return;
			}
		}
		System.out.println("1000 random arrays: all sorted");
	}

	/** Insertion sort, with a bug. */
	static void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int x = a[i];
			int j = i - 1;
			while (j > 0 && a[j] > x) {                 // should be j >= 0
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = x;
		}
	}
}
