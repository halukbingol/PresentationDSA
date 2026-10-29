/** int[] holds numbers; Integer[] holds arrows to Integer objects. */
public class Boxing {
	static long used() {
		Runtime rt = Runtime.getRuntime();
		return rt.totalMemory() - rt.freeMemory();
	}

	public static void main(String[] args) {
		int n = 10_000_000;
		System.gc();
		long before = used();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = i;
		}
		long afterInts = used();
		Integer[] boxed = new Integer[n];
		for (int i = 0; i < n; i++) {
			boxed[i] = i;                    // autoboxing
		}
		long afterBoxed = used();
		long mbInts = (afterInts - before) / 1_000_000;
		long mbBoxed = (afterBoxed - afterInts) / 1_000_000;
		System.out.println("int[]     " + mbInts + " MB");
		System.out.println("Integer[] " + mbBoxed + " MB");
		System.out.println(numbers[n - 1] + " " + boxed[n - 1]);
	}
}
