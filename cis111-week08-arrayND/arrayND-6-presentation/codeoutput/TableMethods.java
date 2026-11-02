import java.util.Arrays;
public class TableMethods {
	static int[] rowTotals(int[][] t) {
		int[] totals = new int[t.length];          // one per row
		for (int r = 0; r < t.length; r++) {
			for (int c = 0; c < t[r].length; c++) {
				totals[r] = totals[r] + t[r][c];
			}
		}
		return totals;
	}
	static int[][] transpose(int[][] t) {          // t is rectangular
		int[][] result = new int[t[0].length][t.length];
		for (int r = 0; r < t.length; r++) {
			for (int c = 0; c < t[r].length; c++) {
				result[c][r] = t[r][c];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64}, {55, 61, 70, 80}};
		System.out.println(Arrays.toString(rowTotals(s)));
		System.out.println(Arrays.deepToString(transpose(s)));
	}
}
