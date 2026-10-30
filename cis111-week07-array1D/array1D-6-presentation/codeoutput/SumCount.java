public class SumCount {
	public static void main(String[] args) {
		int[] scores = {72, 45, 90, 58, 86};

		int sum = 0;                          // accumulate
		int passed = 0;                       // count
		for (int i = 0; i < scores.length; i++) {
			sum = sum + scores[i];
			if (scores[i] >= 60) {
				passed++;
			}
		}
		double avg = (double) sum / scores.length;
		System.out.println("sum " + sum + ", average " + avg);
		System.out.println(passed + " of " + scores.length
				+ " passed");
	}
}
