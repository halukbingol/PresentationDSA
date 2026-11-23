public class FinallyDemo {
	public static void main(String[] args) {
		show("80");
		show("eighty");
	}

	static void show(String text) {
		try {
			int n = Integer.parseInt(text);
			System.out.println("score " + n);
		} catch (NumberFormatException e) {
			System.out.println("not a number: " + text);
		} finally {
			System.out.println("  finally runs");
		}
	}
}
