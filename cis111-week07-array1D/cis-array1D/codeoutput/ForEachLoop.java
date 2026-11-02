public class ForEachLoop {
	public static void main(String[] args) {
		int[] steps = {4200, 7800, 6100, 9900};
		int total = 0;
		for (int s : steps) {          // for each s in steps
			total = total + s;
		}
		System.out.println("total " + total);
		for (int s : steps) {
			s = s * 2;                 // only the copy s
		}
		System.out.println(steps[0]);
	}
}
