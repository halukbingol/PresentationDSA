public class AboveAverage {
	public static void main(String[] args) {
		String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
		double[] highs = {14.0, 16.5, 13.0, 18.5, 13.0};

		double sum = 0;
		for (double t : highs) {              // pass 1
			sum = sum + t;
		}
		double average = sum / highs.length;
		System.out.println("average " + average);
		for (int i = 0; i < highs.length; i++) {   // pass 2
			if (highs[i] > average) {
				System.out.println(days[i] + " " + highs[i]);
			}
		}
	}
}
