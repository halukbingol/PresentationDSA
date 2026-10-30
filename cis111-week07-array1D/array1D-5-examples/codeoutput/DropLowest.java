public class DropLowest {
	public static void main(String[] args) {
		int[] quiz = {8, 4, 10, 7, 9};

		int sum = 0;                  // accumulate
		int low = quiz[0];            // best so far
		for (int q : quiz) {
			sum = sum + q;
			if (q < low) {
				low = q;
			}
		}
		int n = quiz.length - 1;
		double avg = (double) (sum - low) / n;
		System.out.println(sum + " " + low + " " + avg);
	}
}
