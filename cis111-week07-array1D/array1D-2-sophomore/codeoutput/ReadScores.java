import java.util.Scanner;

public class ReadScores {
	public static void main(String[] args) {
		final int CAPACITY = 100;
		int[] scores = new int[CAPACITY];
		int size = 0;
		Scanner in = new Scanner(System.in);
		while (size < CAPACITY && in.hasNextInt()) {
			scores[size] = in.nextInt();      // until a
			size++;                           // non-number
		}
		int max = 0;                          // index
		for (int i = 1; i < size; i++) {
			if (scores[i] > scores[max]) {
				max = i;
			}
		}
		for (int i = 0; i < size; i++) {
			String mark = (i == max) ? "  <== largest" : "";
			System.out.println(scores[i] + mark);
		}
	}
}
