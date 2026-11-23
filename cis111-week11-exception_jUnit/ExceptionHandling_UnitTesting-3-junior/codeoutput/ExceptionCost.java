public class ExceptionCost {
	static final int N = 1_000_000;

	public static void main(String[] args) {
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = (i % 2 == 0) ? String.valueOf(i % 100) : "x" + (i % 100);
		}
		for (int round = 1; round <= 2; round++) {          // round 1 warms up the JIT
			long t0 = System.nanoTime();
			int a = withCatch(words);
			long t1 = System.nanoTime();
			int b = withCheck(words);
			long t2 = System.nanoTime();
			if (round == 2) {
				System.out.printf("try/catch: %4d ms  (%d numbers)%n", (t1 - t0) / 1_000_000, a);
				System.out.printf("check:     %4d ms  (%d numbers)%n", (t2 - t1) / 1_000_000, b);
			}
		}
	}

	static int withCatch(String[] words) {                // half of the words throw
		int count = 0;
		for (String w : words) {
			try {
				Integer.parseInt(w);
				count++;
			} catch (NumberFormatException e) {
				// not a number
			}
		}
		return count;
	}

	static int withCheck(String[] words) {                // no exception at all
		int count = 0;
		for (String w : words) {
			if (isDigits(w)) {
				count++;
			}
		}
		return count;
	}

	static boolean isDigits(String w) {
		if (w.isEmpty()) {
			return false;
		}
		for (int i = 0; i < w.length(); i++) {
			if (!Character.isDigit(w.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
