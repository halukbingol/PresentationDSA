public class FirstArray {
	public static void main(String[] args) {
		int[] scores = new int[4];   // all 0

		scores[0] = 85;
		scores[1] = 72;
		scores[3] = 90;              // [2] stays 0

		System.out.println("length " + scores.length);
		for (int i = 0; i < scores.length; i++) {
			System.out.println(i + ": " + scores[i]);
		}
	}
}
