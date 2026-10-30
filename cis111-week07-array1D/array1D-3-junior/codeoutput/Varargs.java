public class Varargs {
	/** The largest of one or more numbers. */
	static int max(int first, int... rest) {  // rest: int[]
		int best = first;
		for (int x : rest) {
			if (x > best) {
				best = x;
			}
		}
		return best;
	}

	public static void main(String[] args) {
		System.out.println(max(7));
		System.out.println(max(7, 3, 12, 5));
		int[] more = {20, 1};
		System.out.println(max(7, more));     // an array
		System.out.printf("%d of %d%n", 3, 4);
	}
}
