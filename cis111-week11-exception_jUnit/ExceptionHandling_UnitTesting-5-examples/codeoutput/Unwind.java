public class Unwind {
	public static void main(String[] args) {
		try {
			average();
		} catch (IllegalStateException e) {
			System.out.println("main handles it: " + e.getMessage());
		}
		System.out.println("main goes on");
	}

	static void average() {
		try {
			readScore();
			System.out.println("never printed");
		} finally {
			System.out.println("average: finally");
		}
	}

	static void readScore() {
		System.out.println("readScore throws");
		throw new IllegalStateException("empty file");
	}
}
