public class Swap {
	public static void main(String[] args) {
		int[] w = {5, 8, 3};
		w[0] = w[2];               // wrong: old w[0] lost
		w[2] = w[0];
		System.out.println(w[0] + " " + w[1] + " " + w[2]);

		int[] a = {5, 8, 3};
		int temp = a[0];           // right: keep a copy
		a[0] = a[2];
		a[2] = temp;
		System.out.println(a[0] + " " + a[1] + " " + a[2]);
	}
}
