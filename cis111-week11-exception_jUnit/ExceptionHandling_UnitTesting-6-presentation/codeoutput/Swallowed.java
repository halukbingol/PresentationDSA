public class Swallowed {
	public static void main(String[] args) {
		String[] typed = {"72", "8S", "90"};
		int total = 0;
		for (String t : typed) {
			try {
				total = total + Integer.parseInt(t);
			} catch (NumberFormatException e) {
				// nothing here: the error is swallowed
			}
		}
		System.out.println("total " + total);
	}
}
