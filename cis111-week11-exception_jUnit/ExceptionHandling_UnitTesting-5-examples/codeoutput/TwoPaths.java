public class TwoPaths {
	public static void main(String[] args) {
		String[] inputs = {"84", "0", "abc"};
		for (String text : inputs) {
			try {
				int n = Integer.parseInt(text);   // read
				int share = 840 / n;              // compute
				System.out.println("share " + share);   // write
			} catch (NumberFormatException e) {
				System.out.println("handler: not a number: " + text);
			} catch (ArithmeticException e) {
				System.out.println("handler: " + e.getMessage());
			}
			System.out.println("  next task");
		}
	}
}
