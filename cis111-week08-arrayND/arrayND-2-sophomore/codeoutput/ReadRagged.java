import java.util.Arrays;
import java.util.Scanner;
public class ReadRagged {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int[][] t = new int[rows][];
		for (int r = 0; r < rows; r++) {
			int length = in.nextInt();
			t[r] = new int[length];
			for (int c = 0; c < length; c++) {
				t[r][c] = in.nextInt();
			}
		}
		System.out.println(Arrays.deepToString(t));
	}
}
