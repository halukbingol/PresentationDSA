public class AssertDemo {
	public static void main(String[] args) {
		int[] scores = {72, -500, 90};     // -500: a typo
		int total = 0;
		for (int s : scores) {
			total = total + s;
		}
		double average = (double) total / scores.length;
		assert average >= 0 && average <= 100
				: "average out of range: " + average;
		System.out.println("average " + average);
	}
}
