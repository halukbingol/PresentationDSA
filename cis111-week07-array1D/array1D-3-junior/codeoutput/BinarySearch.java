/** Linear and binary search, counting the elements they look at. */
public class BinarySearch {
	static int steps;

	static int linear(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			steps++;
			if (a[i] == key) {
				return i;
			}
		}
		return -1;
	}

	static int binary(int[] a, int key) {      // a must be sorted
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {                      // key is in a[lo..hi]
			int mid = lo + (hi - lo) / 2;
			steps++;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] < key) {
				lo = mid + 1;                   // the right half
			} else {
				hi = mid - 1;                   // the left half
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.printf("%10s %10s %7s%n", "n", "linear", "binary");
		for (int n = 1_000; n <= 10_000_000; n *= 10) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = 2 * i;                   // sorted: 0, 2, 4, ...
			}
			steps = 0;
			linear(a, 1);                       // 1 is not there:
			int linearSteps = steps;            // the worst case
			steps = 0;
			binary(a, 1);
			System.out.printf("%,10d %,10d %7d%n", n, linearSteps, steps);
		}
	}
}
