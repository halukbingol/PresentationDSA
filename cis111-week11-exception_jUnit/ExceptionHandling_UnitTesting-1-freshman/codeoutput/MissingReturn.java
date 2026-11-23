public class MissingReturn {
	public static void main(String[] args) {
		System.out.println(parse("42"));
	}

	static int parse(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			System.out.println("not a number: " + text);
		}
	}
}
