public class LoopKinds {
	public static void main(String[] args) {
		double[][] highs = {{14.0, 16.5, 13.0},
		                    {18.5, 13.0, 15.5}};
		for (int w = 0; w < highs.length; w++) {
			for (int d = 0; d < highs[w].length; d++) {
				System.out.print("week " + w + ", day " + d);
				System.out.println(": " + highs[w][d]);
			}
		}
		double sum = 0;
		for (double[] week : highs) {
			for (double h : week) {
				sum = sum + h;
			}
		}
		System.out.println("sum " + sum);
	}
}
