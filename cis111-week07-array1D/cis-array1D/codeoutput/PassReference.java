import java.util.Arrays;
public class PassReference {
	static void addBonus(int[] a, int bonus) {
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] + bonus;          // the caller's array
		}
	}
	static int[] doubled(int[] a) {
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = 2 * a[i];
		}
		return result;                    // a new array
	}
	public static void main(String[] args) {
		int[] scores = {70, 80, 90};
		addBonus(scores, 5);
		System.out.println(Arrays.toString(scores));
		int[] big = doubled(scores);
		System.out.println(Arrays.toString(big));
	}
}
