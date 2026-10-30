public class Neighbors {
	public static void main(String[] args) {
		int[][] h = {{1, 2, 3},
		             {4, 5, 6},
		             {7, 8, 9}};
		int r = 0;
		int c = 1;  // the cell with 2
		int sum = 0;
		if (r > 0)               { sum = sum + h[r - 1][c]; }
		if (r < h.length - 1)    { sum = sum + h[r + 1][c]; }
		if (c > 0)               { sum = sum + h[r][c - 1]; }
		if (c < h[r].length - 1) { sum = sum + h[r][c + 1]; }
		System.out.println("cell " + h[r][c]);
		System.out.println("sum of its neighbors " + sum);
	}
}
