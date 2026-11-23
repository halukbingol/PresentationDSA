public class Records {
	/** A record of the file is wrong: a checked exception of this program. */
	static class BadRecordException extends Exception {
		BadRecordException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public static void main(String[] args) throws BadRecordException {
		String[] lines = {"Ada,91", "Alan,85", "Grace,9O"};
		int total = 0;
		for (int i = 0; i < lines.length; i++) {
			total += score(lines[i], i + 1);
		}
		System.out.println("total " + total);
	}

	static int score(String line, int number) throws BadRecordException {
		String[] parts = line.split(",");
		try {
			return Integer.parseInt(parts[1]);
		} catch (NumberFormatException e) {
			throw new BadRecordException("record " + number + ": " + line, e);
		}
	}
}
