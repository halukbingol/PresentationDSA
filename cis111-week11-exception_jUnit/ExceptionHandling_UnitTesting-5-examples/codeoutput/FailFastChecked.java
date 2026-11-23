public class FailFastChecked {
	static int[] stock = new int[3];

	public static void main(String[] args) {
		setStock(1, -4);
		System.out.println("stored");
	}

	static void setStock(int item, int count) {
		if (count < 0) {                       // the precondition, checked first
			throw new IllegalArgumentException("count must be >= 0, was " + count);
		}
		stock[item] = count;
	}
}
