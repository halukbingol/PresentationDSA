public class FourD {
	public static void main(String[] args) {
		int[][][][] d = new int[2][3][4][5];     // 4 indices
		int cells = 0;
		for (int a = 0; a < d.length; a++) {
			for (int b = 0; b < d[a].length; b++) {
				for (int c = 0; c < d[a][b].length; c++) {
					cells = cells + d[a][b][c].length;
				}
			}
		}
		System.out.println(cells + " cells = 2 * 3 * 4 * 5");
		System.out.println(d.getClass().getSimpleName());
	}
}
