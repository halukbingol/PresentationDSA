public class Rectangle {
	public static void main(String[] args) {
		System.out.println(area(3, 4));
		try {
			System.out.println(area(3, -4));
		} catch (IllegalArgumentException e) {
			System.out.println("error: " + e.getMessage());
		}
	}

	/** Returns w * h; both sides must be at least 0. */
	static int area(int w, int h) {
		if (w < 0 || h < 0) {
			throw new IllegalArgumentException(
					"bad sides: " + w + ", " + h);
		}
		return w * h;
	}
}
