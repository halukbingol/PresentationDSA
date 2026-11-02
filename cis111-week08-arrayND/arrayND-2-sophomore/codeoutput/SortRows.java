import java.util.Arrays;
public class SortRows {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64},
		             {55, 61, 70, 80},
		             {90, 88, 93, 99}};
		for (int[] row : s) {
			Arrays.sort(row);  // one row
		}
		System.out.println(Arrays.deepToString(s));
		int[] best = new int[s.length];
		for (int r = 0; r < s.length; r++) {
			best[r] = s[r][s[r].length - 1];
		}
		System.out.println(Arrays.toString(best));
	}
}
