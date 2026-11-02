public class MatMulGrowth {
	static double[][] random(int n) {
		double[][] t = new double[n][n];
		for (double[] row : t) {
			for (int c = 0; c < n; c++) {
				row[c] = Math.random();
			}
		}
		return t;
	}
	static double[][] multiply(double[][] a, double[][] b) {
		int n = a.length;
		double[][] c = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int x = 0; x < n; x++) {
					c[i][j] += a[i][x] * b[x][j];
				}
			}
		}
		return c;
	}
	public static void main(String[] args) {
		multiply(random(200), random(200));       // warm up
		for (int n = 100; n <= 800; n = n * 2) {
			double[][] a = random(n), b = random(n);
			long t0 = System.nanoTime();
			multiply(a, b);
			long ms = (System.nanoTime() - t0) / 1_000_000;
			System.out.printf("n = %4d: %5d ms%n", n, ms);
		}
	}
}
