public class RowByRow {
	public static void main(String[] args) {
		int[][] order = new int[3][4];
		int step = 1;
		for (int r = 0; r < order.length; r++) {
			for (int c = 0; c < order[r].length; c++) {
				order[r][c] = step;
				step++;
			}
		}
		for (int[] row : order) {
			for (int x : row) {
				System.out.printf("%3d", x);
			}
			System.out.println();
		}
	}
}
