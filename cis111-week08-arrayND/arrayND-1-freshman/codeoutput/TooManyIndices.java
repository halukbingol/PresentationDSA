public class TooManyIndices {
	public static void main(String[] args) {
		int[][] t = {{1, 2}, {3, 4}};
		int a = t[0][0][0];  // three indices for two dimensions
		int b = t[0];        // one index gives a row, not an int
	}
}
