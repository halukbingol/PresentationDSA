public class Printf {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64},
		             {55, 61, 70, 80},
		             {90, 88, 93, 99}};
		for (int r = 0; r < s.length; r++) {
			int sum = 0;
			for (int c = 0; c < s[r].length; c++) {
				System.out.printf("%5d", s[r][c]);
				sum = sum + s[r][c];
			}
			double avg = (double) sum / s[r].length;
			System.out.printf("%8.1f%n", avg);
		}
	}
}
