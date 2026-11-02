import java.util.Arrays;
public class DefensiveDeep {
	static class Board {
		private final int[][] cells = {{1, 2}, {3, 4}};
		int[][] shallow() { return cells.clone(); }      // new outer array, same rows
		int[][] deep() {
			int[][] copy = new int[cells.length][];
			for (int r = 0; r < cells.length; r++) { copy[r] = cells[r].clone(); }
			return copy;
		}
	}

	public static void main(String[] args) {
		Board b = new Board();
		b.deep()[0][0] = 7;                              // only a copy changes
		System.out.println(Arrays.deepToString(b.cells));
		b.shallow()[0][0] = 9;                           // the board changes!
		System.out.println(Arrays.deepToString(b.cells));
	}
}
