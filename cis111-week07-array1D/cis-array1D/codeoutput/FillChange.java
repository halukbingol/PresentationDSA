import java.util.Arrays;

public class FillChange {
	public static void main(String[] args) {
		int[] squares = new int[6];
		for (int i = 0; i < squares.length; i++) {
			squares[i] = i * i;                   // from i
		}
		System.out.println(Arrays.toString(squares));

		int[] scores = {72, 95, 58, 88};
		for (int i = 0; i < scores.length; i++) {
			scores[i] = Math.min(scores[i] + 10, 100);
		}
		System.out.println(Arrays.toString(scores));
	}
}
