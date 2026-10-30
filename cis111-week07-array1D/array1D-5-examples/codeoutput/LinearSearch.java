public class LinearSearch {
	/** Index of the first a[i] >= x, or -1 if none. */
	static int firstAtLeast(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= x) {
				return i;           // the first match
			}
		}
		return -1;                  // every element checked
	}

	public static void main(String[] args) {
		int[] scores = {72, 85, 90, 64, 95};
		System.out.println(firstAtLeast(scores, 90));
		System.out.println(firstAtLeast(scores, 100));
	}
}
