public class InitRows {
	public static void main(String[] args) {
		int[][] square = {{1, 2}, {3, 4}};
		int[][] wide = {{1, 2, 3, 4, 5}};     // one row
		int[][] tall = {{1}, {2}, {3}};       // one column
		int[][] odd = {{1}, {2, 3}, {}};      // ragged
		System.out.println(square.length);   // rows
		System.out.println(wide[0].length);  // cells of row 0
		System.out.println(tall.length);     // rows
		System.out.println(odd[2].length);   // cells of row 2
	}
}
