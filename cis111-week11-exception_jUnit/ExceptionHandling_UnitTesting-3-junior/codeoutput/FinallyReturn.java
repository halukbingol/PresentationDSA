public class FinallyReturn {
	public static void main(String[] args) {
		System.out.println("value: " + value());
		System.out.println("risky: " + risky());
	}

	static int value() {
		try {
			return 1;
		} finally {
			return 2;                  // replaces 1
		}
	}

	static int risky() {
		try {
			throw new IllegalStateException("lost");
		} finally {
			return 3;                  // exception lost
		}
	}
}
