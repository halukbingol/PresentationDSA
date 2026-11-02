public class FirstArray {
	public static void main(String[] args) {
		int[] scores = new int[4];       // 4 elements, all 0
		scores[0] = 85;
		scores[1] = 72;
		scores[3] = 90;                  // scores[2] stays 0
		for (int i = 0; i < scores.length; i++) {
			System.out.println(i + ": " + scores[i]);
		}
		String[] days = {"Mon", "Tue", "Wed"};   // a list
		System.out.println(days.length + " days");
		System.out.println(days[days.length - 1]);
	}
}
