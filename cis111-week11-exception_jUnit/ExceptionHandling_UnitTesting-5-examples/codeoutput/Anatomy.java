public class Anatomy {
	public static void main(String[] args) {
		try {
			readScore("8S");
		} catch (IllegalArgumentException e) {
			System.out.println("type:    " + e.getClass().getName());
			System.out.println("message: " + e.getMessage());
			System.out.println("where:   " + e.getStackTrace()[0]);
			System.out.println("cause:   " + e.getCause());
		}
	}

	static int readScore(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("bad score " + text, e);
		}
	}
}
