import java.util.Arrays;

public class ArraysLibrary {
	public static void main(String[] args) {
		int[] a = {72, 85, 90, 64, 78};
		System.out.println(Arrays.toString(a));

		int[] s = Arrays.copyOf(a, a.length);
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
		System.out.println(Arrays.binarySearch(s, 85));
		int[] top = Arrays.copyOfRange(s, 2, 5);  // [2, 5)
		System.out.println(Arrays.toString(top));
		int[] longer = Arrays.copyOf(a, 7);       // 0 pads
		System.out.println(Arrays.toString(longer));
		Arrays.fill(top, -1);
		System.out.println(Arrays.toString(top));
	}
}
