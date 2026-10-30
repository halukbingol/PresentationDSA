import java.util.Arrays;

public class CopyCompare {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int[] alias = a;                      // no copy
		int[] c1 = a.clone();
		int[] c2 = Arrays.copyOf(a, a.length);
		int[] c3 = new int[a.length];
		System.arraycopy(a, 0, c3, 0, a.length);
		a[0] = 99;                            // change a
		System.out.println(Arrays.toString(alias));
		System.out.println(Arrays.toString(c1));
		System.out.println(Arrays.toString(c2));
		System.out.println(Arrays.toString(c3));
		System.out.println(c1 == c2);
		System.out.println(Arrays.equals(c1, c2));
	}
}
