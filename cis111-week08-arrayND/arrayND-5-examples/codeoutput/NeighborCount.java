public class NeighborCount {
	public static void main(String[] args) {
		int rows = 3;
		int cols = 4;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				int n = 0;  // up, down, left, right
				if (r > 0)        { n++; }
				if (r < rows - 1) { n++; }
				if (c > 0)        { n++; }
				if (c < cols - 1) { n++; }
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}
