/** Temperatures in degrees Celsius and Fahrenheit. */
public class Temperature {

	/** c degrees Celsius in Fahrenheit. */
	public static double toFahrenheit(double c) {
		return c * 9 / 5 + 32.5;      // a bug: 32.5
	}

	/** True if water freezes at c degrees C. */
	public static boolean isFreezing(double c) {
		return c <= 0;
	}

	/** The coldest; t must not be empty. */
	public static double coldest(double[] t) {
		if (t.length == 0) {
			throw new IllegalArgumentException("empty");
		}
		double min = t[0];
		for (double x : t) {
			if (x < min) {
				min = x;
			}
		}
		return min;
	}
}
