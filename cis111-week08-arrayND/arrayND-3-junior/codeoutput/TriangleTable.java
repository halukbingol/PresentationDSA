public class TriangleTable {
	// road distances in km, about; only c <= r is stored
	static int[][] dist = {{0},                 // Istanbul
	                       {450, 0},            // Ankara
	                       {480, 580, 0},       // Izmir
	                       {700, 480, 450, 0}}; // Antalya

	static int get(int a, int b) {              // symmetric
		return a >= b ? dist[a][b] : dist[b][a];
	}

	public static void main(String[] args) {
		System.out.println(get(1, 3) + " " + get(3, 1));
		int n = dist.length;
		System.out.println(n * (n + 1) / 2 + " of " + n * n);
	}
}
