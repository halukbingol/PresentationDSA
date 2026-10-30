public class RowMajor {
	public static void main(String[] args) {
		int rows = 3;
		int cols = 4;
		int[][] k = new int[rows][cols];
		int next = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				k[r][c] = next;  // the visiting order
				next++;
				System.out.printf("%3d", k[r][c]);
			}
			System.out.println();
		}
		int cell = 9;                           // and back:
		System.out.println(cell / cols + ", " + cell % cols);
	}
}
