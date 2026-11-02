public class LoopOrder {
	public static void main(String[] args) {
		int n = 4000;
		int[][] t = new int[n][n];
		for (int round = 0; round < 3; round++) {
			long t0 = System.nanoTime();
			long a = 0;
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) { a += t[r][c]; }   // row by row
			}
			long t1 = System.nanoTime();
			long b = 0;
			for (int c = 0; c < n; c++) {
				for (int r = 0; r < n; r++) { b += t[r][c]; }   // column by column
			}
			long t2 = System.nanoTime();
			System.out.printf("rows %3d ms, columns %4d ms, same sum: %b%n",
					(t1 - t0) / 1000000, (t2 - t1) / 1000000, a == b);
		}
	}
}
