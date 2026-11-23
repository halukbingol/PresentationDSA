public class DeepTrace {
	public static void main(String[] args) {
		String[] lines = {"72", "85", "eighty"};
		printReport(lines);
	}

	static void printReport(String[] lines) {
		System.out.println("average " + average(lines));
	}

	static double average(String[] lines) {
		int sum = 0;
		for (String line : lines) {
			sum = sum + Integer.parseInt(line);
		}
		return (double) sum / lines.length;
	}
}
