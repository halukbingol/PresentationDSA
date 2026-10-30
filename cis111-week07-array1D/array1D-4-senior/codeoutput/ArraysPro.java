import java.util.Arrays;
import java.util.Random;

/** Less known parts of java.util.Arrays. */
public class ArraysPro {
	public static void main(String[] args) {
		int[] a = {3, 1, 4, 1, 5, 9, 2, 6};
		int[] b = {3, 1, 4, 1, 6, 9, 2, 6};
		System.out.println(Arrays.mismatch(a, b));  // index
		System.out.println(Arrays.compare(a, b));   // a < b
		int h1 = Arrays.hashCode(a);
		System.out.println(h1 == Arrays.hashCode(a.clone()));
		System.out.println(Arrays.stream(a).sum());

		int[] big = new Random(7).ints(2_000_000)
				.toArray();
		Arrays.parallelSort(big);              // all cores
		System.out.println(big[0] <= big[1]);
	}
}
