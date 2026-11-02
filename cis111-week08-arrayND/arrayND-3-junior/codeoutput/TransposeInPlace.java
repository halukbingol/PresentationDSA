import java.util.Arrays;
public class TransposeInPlace {
	public static void main(String[] args) {
		int[][] t = {{1, 2, 3},
		             {4, 5, 6},
		             {7, 8, 9}};  // square
		for (int r = 0; r < t.length; r++) {
			for (int c = r + 1; c < t.length; c++) {
				int temp = t[r][c];
				t[r][c] = t[c][r];
				t[c][r] = temp;
			}
		}
		System.out.println(Arrays.deepToString(t));
	}
}
