public class FinalTable {
	public static void main(String[] args) {
		final int[][] t = {{1, 2}, {3, 4}};
		t = new int[2][2];  // not allowed: the variable
	}
}
