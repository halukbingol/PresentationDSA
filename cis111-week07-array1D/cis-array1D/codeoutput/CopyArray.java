import java.util.Arrays;
public class CopyArray {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int[] alias = a;                  // no copy
		int[] c = new int[a.length];      // a copy by hand
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}
		int[] d = Arrays.copyOf(a, a.length); // shorter
		a[0] = 99;
		System.out.println(Arrays.toString(alias));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));
		System.out.println(a == alias);
		System.out.println(c == d);
		System.out.println(Arrays.equals(c, d));
	}
}
