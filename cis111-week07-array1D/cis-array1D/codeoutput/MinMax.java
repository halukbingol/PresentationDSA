public class MinMax {
	public static void main(String[] args) {
		String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
		double[] rain = {2.5, 0.0, 11.5, 4.0, 11.5};  // mm

		int wet = 0;                 // index of the best
		int dry = 0;
		for (int i = 1; i < rain.length; i++) {
			if (rain[i] > rain[wet]) {
				wet = i;
			}
			if (rain[i] < rain[dry]) {
				dry = i;
			}
		}
		System.out.println("wettest " + days[wet]);
		System.out.println("driest  " + days[dry]);
	}
}
