/** counts[v]: how often v occurs; the value is the index. */
public class Histogram {
	public static void main(String[] args) {
		int[] scores = {72, 85, 90, 64, 78, 55, 81, 93, 67,
				74, 88, 79, 45, 70, 83, 76, 98, 62, 71, 86};
		int[] counts = new int[11];        // 0-9, ..., 100
		for (int s : scores) {
			counts[s / 10]++;
		}
		for (int b = 4; b <= 9; b++) {
			System.out.print(b * 10 + "s | ");
			for (int k = 0; k < counts[b]; k++) {
				System.out.print("*");
			}
			System.out.println(" " + counts[b]);
		}
	}
}
