public class Life {
	static boolean[][] step(boolean[][] g) {
		int n = g.length, m = g[0].length;
		boolean[][] next = new boolean[n][m];         // a second table
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				int k = 0;                            // live neighbors, of 8
				for (int dr = -1; dr <= 1; dr++) {
					for (int dc = -1; dc <= 1; dc++) {
						int rr = r + dr, cc = c + dc;
						if ((dr != 0 || dc != 0) && rr >= 0 && rr < n
								&& cc >= 0 && cc < m && g[rr][cc]) { k++; }
					}
				}
				next[r][c] = k == 3 || (g[r][c] && k == 2);
			}
		}
		return next;
	}

	public static void main(String[] args) {
		boolean[][] g = new boolean[5][5];
		g[2][1] = g[2][2] = g[2][3] = true;       // a blinker
		boolean[][][] gens = {g, step(g), step(step(g))};
		for (int r = 0; r < g.length; r++) {      // each row
			for (boolean[][] t : gens) {
				for (boolean x : t[r]) {
					System.out.print(x ? '#' : '.');
				}
				System.out.print("   ");
			}
			System.out.println();
		}
	}
}
