import java.io.IOException;

/** A one-line summary of the scores of a ScoreSource. */
public class Report {
	private final ScoreSource source;

	public Report(ScoreSource source) {   // passed in
		this.source = source;
	}

	public String summary() {
		int[] scores;
		try {
			scores = source.read();
		} catch (IOException e) {
			return "no data: " + e.getMessage();
		}
		if (scores.length == 0) {
			return "no scores";
		}
		int sum = 0;
		for (int s : scores) {
			sum += s;
		}
		int average = sum / scores.length;
		return scores.length + " scores, average " + average;
	}
}
