public class Propagate {
	public static void main(String[] args) {
		try {
			System.out.println(total("72,85,x,90"));
		} catch (NumberFormatException e) {
			System.out.println("caught: " + e.getMessage());
		}
	}

	static int total(String line) {
		int sum = 0;
		for (String part : line.split(",")) {
			sum = sum + toScore(part);
		}
		return sum;
	}

	static int toScore(String text) {
		System.out.println("toScore " + text);
		return Integer.parseInt(text);
	}
}
