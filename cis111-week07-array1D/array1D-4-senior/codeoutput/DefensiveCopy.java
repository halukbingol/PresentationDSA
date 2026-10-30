import java.util.Arrays;

public class DefensiveCopy {
	static class Exam {
		public static final String[] LEVELS = {"low", "mid", "high"};
		private final int[] scores;

		Exam(int[] scores) {
			this.scores = scores.clone();    // copy what comes in
		}

		int[] leakyScores() {
			return scores;                   // hands out the inside
		}

		int[] scores() {
			return scores.clone();           // copy what goes out
		}
	}

	public static void main(String[] args) {
		int[] input = {70, 80, 90};
		Exam exam = new Exam(input);
		input[0] = 0;                    // no effect: a copy
		exam.scores()[1] = 0;            // no effect: a copy
		System.out.println(Arrays.toString(exam.scores()));

		exam.leakyScores()[2] = 0;       // changes the inside!
		System.out.println(Arrays.toString(exam.scores()));

		Exam.LEVELS[0] = "hacked";       // final, but mutable
		System.out.println(Arrays.toString(Exam.LEVELS));
	}
}
