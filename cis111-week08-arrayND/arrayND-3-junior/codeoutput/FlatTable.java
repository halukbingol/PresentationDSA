public class FlatTable {
	public static void main(String[] args) {
		int rows = 3, cols = 4;
		int[] flat = new int[rows * cols];      // one array
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				flat[r * cols + c] = 10 * r + c;  // (r, c)
			}
		}
		System.out.println(java.util.Arrays.toString(flat));
		int k = 9;                              // and back
		System.out.println(k / cols + ", " + k % cols);
	}
}
