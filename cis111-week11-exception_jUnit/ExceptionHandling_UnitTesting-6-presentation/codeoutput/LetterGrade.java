public class LetterGrade {
	public static void main(String[] args) {
		System.out.println(letterGrade(85));
		System.out.println(letterGrade(105));
		System.out.println("done");
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
