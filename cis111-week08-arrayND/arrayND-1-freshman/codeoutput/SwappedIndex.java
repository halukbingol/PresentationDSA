public class SwappedIndex {
	public static void main(String[] args) {
		int[][] t = new int[2][3];                // 2 rows, 3 columns
		for (int r = 0; r < t[0].length; r++) {   // wrong: 3 rows?
			for (int c = 0; c < t.length; c++) {  // wrong: 2 columns?
				t[r][c] = r + c;
			}
		}
		System.out.println("done");
	}
}
