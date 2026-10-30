public class FillSquares {
	public static void main(String[] args) {
		int[] squares = new int[6];
		for (int i = 0; i < squares.length; i++) {
			squares[i] = i * i;      // depends on i
		}
		for (int s : squares) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
