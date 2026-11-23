public class Layers {
	public static void main(String[] args) {          // the screen
		String[] file = {"72", "85", "8S", "90"};
		try {
			System.out.println(average(file));
		} catch (NumberFormatException e) {
			System.out.println("Please fix the file, " + e.getMessage());
		}
	}

	static double average(String[] lines) {           // the grade book
		int sum = 0;
		for (int i = 0; i < lines.length; i++) {
			sum = sum + readScore(lines, i);
		}
		return (double) sum / lines.length;
	}

	static int readScore(String[] lines, int i) {     // the reader
		try {
			return Integer.parseInt(lines[i]);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("line " + (i + 1) + ": " + lines[i]);
		}
	}
}
