public class AverageCrash {
	public static void main(String[] args) {
		int[] week1 = {72, 85, 90};
		int[] week2 = {};                 // nobody took it
		System.out.println(average(week1));
		System.out.println(average(week2));
		System.out.println("done");
	}

	static int average(int[] scores) {
		int sum = 0;
		for (int s : scores) {
			sum = sum + s;
		}
		return sum / scores.length;
	}
}
