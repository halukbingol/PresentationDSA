public class OneTable {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64},
		             {55, 61, 70, 80},
		             {90, 88, 93, 99}};
		for (int r = 0; r < s.length; r++) {
			int total = 0;
			for (int q = 0; q < s[r].length; q++) {
				total = total + s[r][q];
			}
			System.out.println(total);
		}
	}
}
