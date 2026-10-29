public class Separators {
	public static void main(String[] args) {
		int[] scores = {72, 85, 90};

		for (int i = 0; i < scores.length; i++) {
			System.out.print(scores[i] + ", ");
		}
		System.out.println();              // one too many

		for (int i = 0; i < scores.length; i++) {
			if (i > 0) {
				System.out.print(", ");    // not before [0]
			}
			System.out.print(scores[i]);
		}
		System.out.println();
	}
}
