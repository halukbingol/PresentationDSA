public class RowColTotals {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64},
		             {55, 61, 70, 80},
		             {90, 88, 93, 99}};
		for (int r = 0; r < s.length; r++) {  // each row
			int total = 0;
			for (int c = 0; c < s[r].length; c++) {
				total = total + s[r][c];
			}
			System.out.println("student " + r + ": " + total);
		}
		for (int c = 0; c < s[0].length; c++) {  // each column
			int total = 0;
			for (int r = 0; r < s.length; r++) {
				total = total + s[r][c];
			}
			System.out.println("quiz " + c + ": " + total);
		}
	}
}
