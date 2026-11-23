public class MultiCatch {
	public static void main(String[] args) {
		String[] lines = {"Ada,91", "Alan", "Grace,9O", "Linus,77"};
		int total = 0;
		int skipped = 0;
		for (String line : lines) {
			try {
				total += Integer.parseInt(line.split(",")[1]);
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				skipped++;
				System.out.println("skip \"" + line + "\": " + e.getClass().getSimpleName());
			}
		}
		System.out.println("total " + total + ", skipped " + skipped);
	}
}
