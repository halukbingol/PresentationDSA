/** Grades of a course: letter grades, passing, averages. */
public class Grades {

	/** Returns the letter grade of a score from 0 to 100. */
	public static char letterGrade(int score) {
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

	/** Returns true if the score is at least 60. */
	public static boolean isPassing(int score) {
		return score >= 60;
	}

	/** Returns the average of the scores; needs at least one. */
	public static double average(int[] scores) {
		if (scores.length == 0) {
			throw new IllegalArgumentException("no scores");
		}
		int sum = 0;
		for (int s : scores) {
			sum = sum + s;
		}
		return (double) sum / scores.length;
	}

	/** Returns the letter grade of every score. */
	public static char[] letterGrades(int[] scores) {
		char[] result = new char[scores.length];
		for (int i = 0; i < scores.length; i++) {
			result[i] = letterGrade(scores[i]);
		}
		return result;
	}
}
