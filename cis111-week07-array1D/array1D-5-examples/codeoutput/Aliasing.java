public class Aliasing {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int[] b = a;                 // the SAME array
		b[0] = 99;
		System.out.println(a[0]);
		System.out.println(a == b);

		int[] c = new int[a.length]; // a NEW array
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];             // copy each element
		}
		c[1] = 77;
		System.out.println(a[1]);
		System.out.println(a == c);
	}
}
