import java.util.Arrays;
public class CopyTable {
	public static void main(String[] args) {
		int[][] a = {{1, 2}, {3, 4}};
		int[][] shallow = Arrays.copyOf(a, a.length);
		int[][] deep = new int[a.length][];
		for (int r = 0; r < a.length; r++) {
			deep[r] = Arrays.copyOf(a[r], a[r].length);
		}
		a[0][0] = 99;
		System.out.println(Arrays.deepToString(shallow));
		System.out.println(Arrays.deepToString(deep));
	}
}
