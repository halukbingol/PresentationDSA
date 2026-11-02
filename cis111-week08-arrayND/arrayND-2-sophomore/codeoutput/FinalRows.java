import java.util.Arrays;
public class FinalRows {
	public static void main(String[] args) {
		final int[][] t = {{1, 2}, {3, 4}};
		t[0][0] = 9;                   // a cell: allowed
		t[1] = new int[] {5, 6, 7};    // a row: allowed
		System.out.println(Arrays.deepToString(t));
	}
}
