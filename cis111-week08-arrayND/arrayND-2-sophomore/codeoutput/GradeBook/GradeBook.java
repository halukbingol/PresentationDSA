/** Methods on a table of scores: one row per student, one column per quiz. */
public class GradeBook {

	/** The total of every row. t may be ragged; t is not changed. */
	public static int[] rowTotals(int[][] t) {
		int[] totals = new int[t.length];
		for (int r = 0; r < t.length; r++) {
			for (int c = 0; c < t[r].length; c++) {
				totals[r] = totals[r] + t[r][c];
			}
		}
		return totals;
	}

	/** The average of every column. t: rectangular, at least one row. */
	public static double[] columnAverages(int[][] t) {
		double[] avg = new double[t[0].length];
		for (int c = 0; c < t[0].length; c++) {
			int sum = 0;
			for (int r = 0; r < t.length; r++) {
				sum = sum + t[r][c];
			}
			avg[c] = sum / t.length;                 // a bug: int division
		}
		return avg;
	}

	/** true if there is a row and every row has the length of row 0. */
	public static boolean isRectangular(int[][] t) {
		if (t.length == 0) { return false; }
		for (int[] row : t) {
			if (row.length != t[0].length) { return false; }
		}
		return true;
	}

	/** A new table: every cell plus bonus, at most 100. t is not changed. */
	public static int[][] withBonus(int[][] t, int bonus) {
		int[][] result = new int[t.length][];
		for (int r = 0; r < t.length; r++) {
			result[r] = new int[t[r].length];
			for (int c = 0; c < t[r].length; c++) {
				result[r][c] = Math.min(t[r][c] + bonus, 100);
			}
		}
		return result;
	}
}
