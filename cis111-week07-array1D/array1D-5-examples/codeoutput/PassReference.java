public class PassReference {
	static void addBonus(int[] a, int bonus) {
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] + bonus;     // the caller's array
		}
	}

	static void replace(int[] a) {
		a = new int[] {0, 0, 0};     // only the local arrow
	}

	static int[] doubled(int[] a) {
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = 2 * a[i];
		}
		return result;               // a new array
	}

	public static void main(String[] args) {
		int[] s = {70, 80, 90};
		addBonus(s, 5);
		System.out.println(s[0] + " " + s[1] + " " + s[2]);
		replace(s);
		System.out.println(s[0] + " " + s[1] + " " + s[2]);
		int[] big = doubled(s);
		System.out.println(big[0] + " " + big[2]);
	}
}
