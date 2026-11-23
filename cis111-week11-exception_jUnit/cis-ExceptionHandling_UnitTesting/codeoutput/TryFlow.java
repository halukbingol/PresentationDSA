public class TryFlow {
	public static void main(String[] args) {
		run("42");
		run("4x2");
	}

	static void run(String text) {
		try {
			System.out.print("A ");
			int n = Integer.parseInt(text);
			System.out.print("B" + n + " ");
		} catch (NumberFormatException e) {
			System.out.print("C ");
		}
		System.out.println("D");
	}
}
