public class ByHand {
	public static void main(String[] args) {
		System.out.println(letterGrade(85));    // should be B
		System.out.println(letterGrade(90));    // should be A
		System.out.println(letterGrade(59));    // should be F
		System.out.println(letterGrade(100));   // should be A
	}

	static char letterGrade(int score) {
		if (score < 0 || score > 100) {
			throw new IllegalArgumentException(
					"score not in 0..100: " + score);
		}
		if (score >= 90) {
			return 'A';
		} else if (score >= 80) {
			return 'B';
		} else if (score >= 70) {
			return 'C';
		} else if (score >= 60) {
			return 'D';
		}
		return 'F';
	}
}
