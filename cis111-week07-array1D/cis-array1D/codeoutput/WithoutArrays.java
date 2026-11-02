public class WithoutArrays {
	public static void main(String[] args) {
		double t0 = 14.0, t1 = 16.5;
		double t2 = 13.0, t3 = 18.5;
		double t4 = 13.0;
		double sum = t0 + t1 + t2 + t3 + t4;
		double avg = sum / 5;
		int warm = 0;
		if (t0 > avg) { warm++; }
		if (t1 > avg) { warm++; }
		if (t2 > avg) { warm++; }
		if (t3 > avg) { warm++; }
		if (t4 > avg) { warm++; }
		System.out.println(avg + " " + warm);
	}
}
