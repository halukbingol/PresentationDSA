public class FailFast {
	static int[] stock = new int[3];

	public static void main(String[] args) {
		setStock(1, -4);              // a wrong value goes in
		System.out.println("stored");
		printBars();                  // and fails here, later
	}

	static void setStock(int item, int count) {
		stock[item] = count;          // no check
	}

	static void printBars() {
		for (int i = 0; i < stock.length; i++) {
			System.out.println(i + " " + "#".repeat(stock[i]));
		}
	}
}
