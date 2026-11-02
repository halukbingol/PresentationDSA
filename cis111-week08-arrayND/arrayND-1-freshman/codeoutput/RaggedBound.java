public class RaggedBound {
	public static void main(String[] args) {
		int[][] tri = {{1}, {1, 1}, {1, 2, 1}};
		for (int r = 0; r < tri.length; r++) {
			for (int c = 0; c < tri[0].length; c++) {  // row 0 only!
				System.out.print(tri[r][c] + " ");
			}
		}
		System.out.println();
		for (int r = 0; r < tri.length; r++) {
			for (int c = 0; c < tri[2].length; c++) {  // row 2 only!
				System.out.print(tri[r][c] + " ");
			}
		}
	}
}
