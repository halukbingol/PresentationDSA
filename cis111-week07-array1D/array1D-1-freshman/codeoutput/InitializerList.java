public class InitializerList {
	public static void main(String[] args) {
		String[] days = {"Mon", "Tue", "Wed", "Thu"};
		double[] prices = {12.5, 8.0, 21.75};

		System.out.println(days.length + " days");
		System.out.println(days[0]);
		System.out.println(days[days.length - 1]);
		System.out.println(prices[prices.length - 1]);

		days[0] = "Monday";      // elements can change
		System.out.println(days[0]);
	}
}
