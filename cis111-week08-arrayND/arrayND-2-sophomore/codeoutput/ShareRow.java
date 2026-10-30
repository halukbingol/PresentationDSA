import java.util.Arrays;
public class ShareRow {
	public static void main(String[] args) {
		int[][] bad = new int[3][];
		Arrays.fill(bad, new int[2]);   // one row only
		bad[0][0] = 7;
		System.out.println(Arrays.deepToString(bad));

		int[][] good = new int[3][2];
		for (int[] row : good) {
			Arrays.fill(row, -1);   // each row
		}
		good[0][0] = 7;
		System.out.println(Arrays.deepToString(good));
	}
}
