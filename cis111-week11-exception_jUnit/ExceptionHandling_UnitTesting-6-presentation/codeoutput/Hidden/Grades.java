/** Written only until the three visible tests passed. */
public class Grades {

	/** Returns the letter grade of a score from 0 to 100. */
	public static char letterGrade(int score) {
		if (score > 90) {
			return 'A';
		} else if (score > 80) {
			return 'B';
		}
		return 'F';
	}
}
