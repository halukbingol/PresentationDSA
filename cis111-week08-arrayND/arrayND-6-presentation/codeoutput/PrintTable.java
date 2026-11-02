import java.util.Arrays;
public class PrintTable {
	public static void main(String[] args) {
		int[][] t = {{1, 2, 3}, {40, 50, 60}};
		System.out.println(t);                      // table
		System.out.println(Arrays.toString(t));     // rows
		System.out.println(Arrays.deepToString(t)); // cells
		for (int r = 0; r < t.length; r++) {
			for (int c = 0; c < t[r].length; c++) {
				System.out.printf("%4d", t[r][c]);   // 4 wide
			}
			System.out.println();
		}
	}
}
