public class FinallyPaths {
	public static void main(String[] args) {
		run(4);                                  // 1. no exception
		run(0);                                  // 2. caught
		run(-1);                                 // 3. not caught
		System.out.println("never printed");
	}

	static void run(int n) {
		try {
			if (n < 0) {
				throw new IllegalStateException("negative");
			}
			System.out.println("12 / " + n + " = " + 12 / n);
		} catch (ArithmeticException e) {
			System.out.println("catch: " + e.getMessage());
		} finally {
			System.out.println("  finally");
		}
	}
}
