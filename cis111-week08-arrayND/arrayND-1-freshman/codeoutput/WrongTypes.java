public class WrongTypes {
	public static void main(String[] args) {
		int[][] t = {{1, 2}, {3.5, 4}};  // a double in an int table
		int[] row = new int[2][2];       // a table is not a row
	}
}
