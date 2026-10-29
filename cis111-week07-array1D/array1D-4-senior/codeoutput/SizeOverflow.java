/** A size computed with int arithmetic can overflow. */
public class SizeOverflow {
	public static void main(String[] args) {
		int count = 600_000_000;         // e.g. from a file
		int bytes = count * 4;           // overflows!
		System.out.println("bytes = " + bytes);
		try {
			byte[] buffer = new byte[bytes];
		} catch (NegativeArraySizeException e) {
			System.out.println(e);
		}
		try {
			int safe = Math.multiplyExact(count, 4);
		} catch (ArithmeticException e) {
			System.out.println(e);       // fails loudly
		}
	}
}
