public class Clock {

	/** Returns the seconds of a day as hh:mm:ss. */
	public static String toClock(int seconds) {
		if (seconds < 0) {
			throw new IllegalArgumentException("negative: " + seconds);
		}
		return String.format("%02d:%02d:%02d", seconds / 3600, seconds / 60 % 60, seconds % 60);
	}
}
