public class NoNew {
	public static void main(String[] args) {
		int score = -5;
		if (score < 0) {
			throw IllegalArgumentException("negative: " + score);
		}
	}
}
