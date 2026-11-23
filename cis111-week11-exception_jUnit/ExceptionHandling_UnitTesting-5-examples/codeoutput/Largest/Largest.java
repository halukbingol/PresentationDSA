public class Largest {

	/** The largest element; a is not empty. */
	public static int max(int[] a) {
		int best = 0;
		for (int x : a) {
			if (x > best) {
				best = x;
			}
		}
		return best;
	}
}
