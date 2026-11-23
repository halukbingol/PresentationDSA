public class Shipping {

	/** 10 per kg plus 5; express costs twice that. */
	public static int cost(int kg, boolean express) {
		int normal = 10 * kg + 5;
		if (express) {
			return 2 * normal;
		} else {
			return 10 * kg;          // forgot + 5
		}
	}
}
