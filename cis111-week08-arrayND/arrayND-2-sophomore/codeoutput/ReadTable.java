import java.util.Scanner;
public class ReadTable {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();  // the sizes come first
		int cols = in.nextInt();
		int[][] t = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				t[r][c] = in.nextInt();      // then row by row
			}
		}
		for (int r = 0; r < rows; r++) {
			int sum = 0;
			for (int c = 0; c < cols; c++) {
				sum = sum + t[r][c];
			}
			System.out.println("row " + r + ": " + sum);
		}
	}
}
