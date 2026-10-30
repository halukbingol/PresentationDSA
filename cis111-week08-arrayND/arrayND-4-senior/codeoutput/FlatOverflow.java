public class FlatOverflow {
	public static void main(String[] args) {
		int rows = 50_000;
		int cols = 50_000;
		int cells = rows * cols;                 // int * int overflows
		System.out.println(cells);
		long exact = (long) rows * cols;         // compute in long
		System.out.println(exact);
		System.out.println(exact > Integer.MAX_VALUE);
		try {
			Math.multiplyExact(rows, cols);      // or fail loudly
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}
