import java.util.Arrays;
public class CountTransform {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64},
		             {55, 61, 70, 80},
		             {90, 88, 93, 99}};
		int high = 0;
		for (int r = 0; r < s.length; r++) {
			for (int c = 0; c < s[r].length; c++) {
				if (s[r][c] >= 90) { high++; }
				s[r][c] = Math.min(s[r][c] + 5, 100);
			}
		}
		System.out.println(high + " cells were 90 or more");
		System.out.println(Arrays.deepToString(s));
	}
}
