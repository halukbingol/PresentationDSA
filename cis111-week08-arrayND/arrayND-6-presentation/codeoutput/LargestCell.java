public class LargestCell {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64},
		             {55, 61, 70, 80},
		             {90, 88, 93, 99}};
		int br = 0;  // the best so far:
		int bc = 0;  // its row and column
		for (int r = 0; r < s.length; r++) {
			for (int c = 0; c < s[r].length; c++) {
				if (s[r][c] > s[br][bc]) {
					br = r;
					bc = c;
				}
			}
		}
		System.out.println("largest " + s[br][bc]);
		System.out.println("row " + br + ", column " + bc);
	}
}
