public class CountPassing {
	public static void main(String[] args) {
		int[] scores = {72, 45, 90, 58, 66, 39};

		int passing = 0;
		for (int s : scores) {
			if (s >= 60) {
				passing++;
			}
		}
		System.out.println(passing + " of "
				+ scores.length + " passed");
	}
}
