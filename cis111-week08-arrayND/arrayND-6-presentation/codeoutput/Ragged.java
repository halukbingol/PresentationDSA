public class Ragged {
	public static void main(String[] args) {
		int[][] tri = new int[4][];  // 4 rows, no row yet
		for (int r = 0; r < tri.length; r++) {
			tri[r] = new int[r + 1];  // row r: r + 1 cells
			for (int c = 0; c < tri[r].length; c++) {
				tri[r][c] = c + 1;
			}
		}
		for (int r = 0; r < tri.length; r++) {
			for (int c = 0; c < tri[r].length; c++) {
				System.out.print(tri[r][c] + " ");
			}
			System.out.println();
		}
	}
}
