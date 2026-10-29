public class Sum {
	static int sum() {
		int[] a = new int[3];
		a[0] = 7;
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			s += a[i];
		}
		return s;
	}
}
