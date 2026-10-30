/** Prefix sums: any range total with one subtraction. */
public class PrefixSums {
	public static void main(String[] args) {
		int[] steps = {4200, 7800, 6100, 9900, 3000, 12000};

		int[] prefix = new int[steps.length + 1];
		for (int i = 0; i < steps.length; i++) {
			prefix[i + 1] = prefix[i] + steps[i];
		}

		int lo = 2;                        // days 2..5
		int hi = 5;
		System.out.println(prefix[hi + 1] - prefix[lo]);
		System.out.println(prefix[steps.length]);   // all
	}
}
