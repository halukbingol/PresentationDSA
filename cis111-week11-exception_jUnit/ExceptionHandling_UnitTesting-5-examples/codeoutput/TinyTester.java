public class TinyTester {
	static int passed = 0;
	static int failed = 0;

	public static void main(String[] args) {
		check("max(3, 9)", 9, max(3, 9));
		check("max(9, 3)", 9, max(9, 3));
		check("max(-2, -7)", -2, max(-2, -7));
		check("max(5, 5)", 5, max(5, 5));
		System.out.println(passed + " passed, " + failed + " failed");
	}

	static void check(String name, int expected, int actual) {
		if (expected == actual) {
			passed++;
		} else {
			failed++;
			System.out.println("FAIL " + name + ": expected " + expected + ", was " + actual);
		}
	}

	static int max(int a, int b) {
		if (a > b) {
			return a;
		} else if (b > a) {
			return b;
		}
		return 0;                                // forgot: a == b
	}
}
