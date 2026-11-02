public class FindCell {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64},
		             {55, 61, 70, 80},
		             {90, 88, 93, 99}};
		int wanted = 70;
		int fr = -1;                      // -1: not found yet
		int fc = -1;
		for (int r = 0; r < s.length && fr == -1; r++) {
			for (int c = 0; c < s[r].length && fr == -1; c++) {
				if (s[r][c] == wanted) {
					fr = r;
					fc = c;
				}
			}
		}
		System.out.println(wanted + " at " + fr + ", " + fc);
	}
}
