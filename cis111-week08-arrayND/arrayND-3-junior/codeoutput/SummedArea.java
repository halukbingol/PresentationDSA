public class SummedArea {
	public static void main(String[] args) {
		int[][] t = {{1, 2, 3, 4},
		             {5, 6, 7, 8},
		             {9, 1, 2, 3}};
		int n = t.length, m = t[0].length;
		int[][] s = new int[n + 1][m + 1];   // sums above-left
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				s[r + 1][c + 1] = t[r][c] + s[r][c + 1] + s[r + 1][c] - s[r][c];
			}
		}
		// rows 1..2, columns 1..3:  6 + 7 + 8 + 1 + 2 + 3 = 27
		int r1 = 1, r2 = 2, c1 = 1, c2 = 3;
		int sum = s[r2 + 1][c2 + 1] - s[r1][c2 + 1] - s[r2 + 1][c1] + s[r1][c1];
		System.out.println(sum);
	}
}
