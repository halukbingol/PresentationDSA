public class SeveralCatches {
	public static void main(String[] args) {
		int[] scores = {72, 85, 90};
		String[] typed = {"1", "x", "7"};
		for (String t : typed) {
			try {
				int i = Integer.parseInt(t);
				System.out.println(scores[i]);
			} catch (NumberFormatException e) {
				System.out.println("not a number: " + t);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
