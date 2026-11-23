public class Deep {
	static int depth = 0;

	static void down() {
		depth++;
		down();                         // no base case
	}

	public static void main(String[] args) {
		try {
			down();
		} catch (StackOverflowError e) {
			System.out.println("calls: " + depth);
		}
	}
}
