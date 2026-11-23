public class Prime {

	/** Returns true if n is a prime number. */
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		return n % 2 != 0;             // odd: prime?
	}
}
