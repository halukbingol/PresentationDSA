public class Clock {

	/** Returns the seconds of a day as hh:mm:ss. */
	public static String toClock(int seconds) {
		if (seconds < 0) {
			throw new IllegalArgumentException("negative: " + seconds);
		}
		int h = seconds / 3600;
		int m = seconds / 60 % 60;
		int s = seconds % 60;
		String result = "";
		if (h < 10) {
			result = result + "0";
		}
		result = result + h + ":";
		if (m < 10) {
			result = result + "0";
		}
		result = result + m + ":";
		if (s < 10) {
			result = result + "0";
		}
		return result + s;
	}
}
