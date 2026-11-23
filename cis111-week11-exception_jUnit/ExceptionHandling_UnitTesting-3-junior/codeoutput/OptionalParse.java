import java.util.Optional;

public class OptionalParse {
	public static void main(String[] args) {
		for (String text : new String[] {"85", "8S"}) {
			Optional<Integer> score = parseScore(text);
			if (score.isPresent()) {
				System.out.println(text + " -> " + score.get());
			} else {
				System.out.println(text + " -> no score");
			}
			System.out.println("  or: " + score.orElse(0));
		}
	}

	/** Empty, not an exception, if text is not a number. */
	static Optional<Integer> parseScore(String text) {
		try {
			return Optional.of(Integer.parseInt(text));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}
}
