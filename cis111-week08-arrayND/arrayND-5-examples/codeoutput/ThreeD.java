public class ThreeD {
	public static void main(String[] args) {
		// taken[floor][row][seat]: is the seat taken?
		boolean[][][] taken = new boolean[2][3][4];
		taken[0][1][2] = true;
		taken[1][0][0] = true;
		taken[1][2][3] = true;
		int count = 0;
		for (int f = 0; f < taken.length; f++) {
			for (int r = 0; r < taken[f].length; r++) {
				for (int s = 0; s < taken[f][r].length; s++) {
					if (taken[f][r][s]) { count++; }
				}
			}
		}
		System.out.println(count + " seats taken");
	}
}
