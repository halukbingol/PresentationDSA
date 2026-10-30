public class FirstTable {
	public static void main(String[] args) {
		int[][] t = new int[2][3];  // 2 rows, 3 columns, all 0
		t[0][0] = 5;
		t[0][2] = 7;
		t[1][1] = 9;                      // t[1][0] stays 0
		for (int r = 0; r < t.length; r++) {
			for (int c = 0; c < t[r].length; c++) {
				System.out.print(t[r][c] + " ");
			}
			System.out.println();
		}
		int[][] m = {{1, 2, 3}, {4, 5, 6}};  // rows in braces
		System.out.println(m.length + " x " + m[0].length);
		System.out.println(m[1][2]);
	}
}
