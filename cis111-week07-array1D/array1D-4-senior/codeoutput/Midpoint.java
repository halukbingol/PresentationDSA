/** The midpoint bug of binary search. */
public class Midpoint {
	public static void main(String[] args) {
		int lo = 1_500_000_000;      // ~2 billion elements
		int hi = 2_000_000_000;

		System.out.println((lo + hi) / 2);       // overflow
		System.out.println(lo + (hi - lo) / 2);  // safe
		System.out.println((lo + hi) >>> 1);     // safe
	}
}
