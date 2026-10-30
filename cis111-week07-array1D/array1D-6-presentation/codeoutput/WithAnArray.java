public class WithAnArray {
	public static void main(String[] args) {
		double[] t = {14.0, 16.5, 13.0,
		              18.5, 13.0};
		double sum = 0;
		for (int i = 0; i < t.length; i++) {
			sum = sum + t[i];
		}
		double avg = sum / t.length;
		int warm = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] > avg) { warm++; }
		}
		System.out.println(avg + " " + warm);
	}
}
