/** Statistics on daily temperatures (whole degrees Celsius). */
public class TempStats {

	/**
	 * Returns the highest temperature.
	 *
	 * @param t the temperatures, at least one; not changed
	 * @return the largest element of t
	 */
	public static int max(int[] t) {
		int max = 0;
		for (int x : t) {
			if (x > max) {
				max = x;
			}
		}
		return max;
	}

	/**
	 * Counts the days colder than a limit.
	 *
	 * @param t     the temperatures; not changed
	 * @param limit the limit
	 * @return how many elements are less than limit
	 */
	public static int countBelow(int[] t, int limit) {
		int count = 0;
		for (int x : t) {
			if (x < limit) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Returns the change from each day to the next.
	 *
	 * @param t the temperatures; not changed
	 * @return a new array d of length t.length - 1 with d[i] = t[i + 1] - t[i]
	 */
	public static int[] changes(int[] t) {
		int[] d = new int[t.length - 1];
		for (int i = 0; i < d.length; i++) {
			d[i] = t[i] - t[i + 1];
		}
		return d;
	}
}
