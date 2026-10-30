public class ForEachTable {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64}, {55, 61, 70, 80}};
		for (int[] row : s) {  // each row is an int[]
			int total = 0;
			for (int x : row) {  // each element of that row
				total = total + x;
			}
			System.out.println(total);
		}
	}
}
