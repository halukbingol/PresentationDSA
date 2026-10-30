import java.util.Arrays;
public class MatMul {
	// a: n x k, b: k x m, the product: n x m
	static int[][] multiply(int[][] a, int[][] b) {
		int n = a.length, k = b.length, m = b[0].length;
		int[][] c = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int x = 0; x < k; x++) {
					c[i][j] = c[i][j] + a[i][x] * b[x][j];
				}
			}
		}
		return c;
	}
	public static void main(String[] args) {
		int[][] a = {{1, 2, 3}, {4, 5, 6}};           // 2 x 3
		int[][] b = {{1, 0}, {0, 1}, {2, 2}};         // 3 x 2
		System.out.println(Arrays.deepToString(multiply(a, b)));
	}
}
