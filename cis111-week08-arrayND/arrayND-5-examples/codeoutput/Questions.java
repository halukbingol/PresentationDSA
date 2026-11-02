public class Questions {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64},  // students x quizzes
		             {55, 61, 70, 80},
		             {90, 88, 93, 99}};
		System.out.println("one cell:   " + s[0][2]);
		int row = 0;
		for (int c = 0; c < s[1].length; c++) {
			row = row + s[1][c];  // student 1
		}
		System.out.println("one row:    " + row);
		int col = 0;
		for (int r = 0; r < s.length; r++) {
			col = col + s[r][3];                    // quiz 3
		}
		System.out.println("one column: " + col);
	}
}
