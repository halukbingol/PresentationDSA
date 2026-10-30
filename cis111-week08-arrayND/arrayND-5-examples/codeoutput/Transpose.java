import java.util.Arrays;
public class Transpose {
	public static void main(String[] args) {
		int[][] t = {{1, 2, 3},
		             {4, 5, 6}};                     // 2 x 3
		int[][] tt = new int[t[0].length][t.length]; // 3 x 2
		for (int r = 0; r < t.length; r++) {
			for (int c = 0; c < t[r].length; c++) {
				tt[c][r] = t[r][c];
			}
		}
		System.out.println(Arrays.deepToString(t));
		System.out.println(Arrays.deepToString(tt));
	}
}
