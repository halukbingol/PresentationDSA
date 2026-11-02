public class MissingRow {
	public static void main(String[] args) {
		int[][] t = new int[3][];  // 3 rows, none created yet
		t[1] = new int[4];         // only row 1 exists
		t[1][0] = 5;
		t[0][0] = 7;  // row 0 was never created
	}
}
