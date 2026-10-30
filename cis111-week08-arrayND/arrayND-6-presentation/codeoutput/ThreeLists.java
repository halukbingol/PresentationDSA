public class ThreeLists {
	public static void main(String[] args) {
		int[] s0 = {72, 85, 90, 64};
		int[] s1 = {55, 61, 70, 80};
		int[] s2 = {90, 88, 93, 99};
		int t0 = 0, t1 = 0, t2 = 0;
		for (int q = 0; q < 4; q++) {
			t0 = t0 + s0[q];
			t1 = t1 + s1[q];
			t2 = t2 + s2[q];
		}
		System.out.println(t0);
		System.out.println(t1);
		System.out.println(t2);
	}
}
