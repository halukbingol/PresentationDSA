import java.util.Arrays;
public class DeepCopy {
	/** Shares no row with t; t may be ragged. */
	static int[][] deepCopy(int[][] t) {
		int[][] copy = new int[t.length][];
		for (int r = 0; r < t.length; r++) {
			copy[r] = Arrays.copyOf(t[r], t[r].length);
		}
		return copy;
	}

	public static void main(String[] args) {
		int[][] a = {{1}, {2, 3}, {4, 5, 6}};
		int[][] b = deepCopy(a);
		b[2][2] = 99;
		System.out.println(Arrays.deepToString(a));
		System.out.println(Arrays.deepToString(b));
	}
}
