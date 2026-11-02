public class ScoresTable {
	public static void main(String[] args) {
		final int STUDENTS = 3;
		final int QUIZZES = 4;
		int[][] scores = new int[STUDENTS][QUIZZES];
		scores[0][0] = 72;
		scores[0][3] = 64;
		scores[2][1] = 88;
		for (int r = 0; r < STUDENTS; r++) {
			for (int c = 0; c < QUIZZES; c++) {
				System.out.print(scores[r][c] + " ");
			}
			System.out.println();
		}
	}
}
