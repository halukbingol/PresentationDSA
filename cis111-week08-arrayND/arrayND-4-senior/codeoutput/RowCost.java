public class RowCost {
	static long used() {
		Runtime rt = Runtime.getRuntime();
		System.gc();
		return rt.totalMemory() - rt.freeMemory();
	}

	public static void main(String[] args) {
		long m0 = used();
		int[][] tall = new int[1_000_000][2];     // 10^6 rows of 2
		long m1 = used();
		int[][] wide = new int[2][1_000_000];     // 2 rows of 10^6
		long m2 = used();
		System.out.printf("tall: %3d MB%n", (m1 - m0) / 1_000_000);
		System.out.printf("wide: %3d MB%n", (m2 - m1) / 1_000_000);
		System.out.println(tall.length + wide.length);  // keep both
	}
}
