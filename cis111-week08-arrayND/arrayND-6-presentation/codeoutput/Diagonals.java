public class Diagonals {
	public static void main(String[] args) {
		char[][] b = {{'X', 'O', 'X'},
		              {'O', 'X', 'O'},
		              {'O', ' ', 'X'}};
		int n = b.length;     // a square board
		boolean down = true;  // b[0][0], b[1][1], b[2][2]
		boolean up = true;    // b[0][2], b[1][1], b[2][0]
		for (int i = 0; i < n; i++) {
			down = down && b[i][i] == 'X';
			up = up && b[i][n - 1 - i] == 'X';
		}
		System.out.println("down " + down + ", up " + up);
	}
}
