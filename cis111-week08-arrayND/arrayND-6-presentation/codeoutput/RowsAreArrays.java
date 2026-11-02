public class RowsAreArrays {
	public static void main(String[] args) {
		int[][] t = {{1, 2, 3}, {4, 5, 6}};
		int[] row = t[1];  // a second arrow to row 1
		row[0] = 99;
		System.out.println(t[1][0]);
		t[0] = new int[] {7, 8};     // a new row 0, length 2
		System.out.println(t[0].length + " " + t[1].length);
	}
}
