public class Pascal {
	public static void main(String[] args) {
		int n = 6;
		int[][] p = new int[n][];
		for (int r = 0; r < n; r++) {
			p[r] = new int[r + 1];   // r + 1 cells
			p[r][0] = 1;
			p[r][r] = 1;
			for (int c = 1; c < r; c++) {
				p[r][c] = p[r - 1][c - 1] + p[r - 1][c];
			}
		}
		for (int[] row : p) {
			for (int x : row) {
				System.out.printf("%3d", x);
			}
			System.out.println();
		}
	}
}
