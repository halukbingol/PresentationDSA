public class SumAverage {
	public static void main(String[] args) {
		int[] scores = {72, 85, 90, 64, 78};

		int sum = 0;                           // start
		for (int i = 0; i < scores.length; i++) {
			sum = sum + scores[i];             // update
		}
		double avg = (double) sum / scores.length;
		System.out.println(sum + " " + avg);

		int[] none = {};                       // empty
		System.out.println((double) 0 / none.length);
	}
}
