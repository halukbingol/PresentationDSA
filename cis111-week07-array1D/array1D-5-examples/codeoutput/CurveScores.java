public class CurveScores {
	static void print(int[] a) {
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] scores = {72, 95, 58, 88};
		print(scores);
		for (int i = 0; i < scores.length; i++) {
			scores[i] = Math.min(scores[i] + 10, 100);
		}
		print(scores);                   // same array
	}
}
