/** Museum tickets: the price depends on the age. */
public class Ticket {

	/**
	 * Returns the price for a visitor of this age:
	 * 0 to 6 free, 7 to 17 pay 50, 18 and older pay 100.
	 * A negative age throws an IllegalArgumentException.
	 */
	public static int price(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("age < 0: " + age);
		}
		if (age <= 6) {
			return 0;
		} else if (age <= 17) {
			return 50;
		}
		return 100;
	}
}
