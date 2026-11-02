import java.util.Scanner;

public class ReadScores {
	public static void main(String[] args) {
		int[] scores = new int[100];          // big enough
		int size = 0;
		Scanner in = new Scanner(System.in);
		while (size < scores.length && in.hasNextInt()) {
			scores[size] = in.nextInt();
			size++;
		}
		for (int i = size - 1; i >= 0; i--) {   // backwards
			System.out.print(scores[i] + " ");
		}
		System.out.println("(" + size + " read)");
	}
}
