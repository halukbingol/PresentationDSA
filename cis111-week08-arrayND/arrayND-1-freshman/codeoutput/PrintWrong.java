import java.util.Arrays;
public class PrintWrong {
	public static void main(String[] args) {
		int[][] t = {{1, 2, 3}, {4, 5, 6}};
		System.out.println(t);
		System.out.println(Arrays.toString(t));
		for (int[] row : t) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println(Arrays.deepToString(t));
	}
}
