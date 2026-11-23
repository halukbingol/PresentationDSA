public class Unreachable {
	public static void main(String[] args) {
		System.out.println(check(-5));
	}

	static int check(int score) {
		if (score < 0) {
			throw new IllegalArgumentException("negative");
			System.out.println("checked");
		}
		return score;
	}
}
