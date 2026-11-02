public class Rotate {
	public static void main(String[] args) {
		char[][] p = {"#..".toCharArray(),
		              "##.".toCharArray()};     // 2 x 3
		int rows = p.length, cols = p[0].length;
		char[][] q = new char[cols][rows];      // 3 x 2
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				q[c][rows - 1 - r] = p[r][c];   // clockwise
			}
		}
		for (char[] row : q) {
			System.out.println(new String(row));
		}
	}
}
