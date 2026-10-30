import java.util.Arrays;
import java.util.stream.IntStream;
public class ParallelRows {
	public static void main(String[] args) {
		int n = 2000;
		int[][] t = new int[n][n];
		for (int[] row : t) {
			Arrays.fill(row, 1);
		}
		long[] rowSum = new long[n];
		IntStream.range(0, n).parallel().forEach(r -> {
			long s = 0;
			for (int x : t[r]) {
				s += x;
			}
			rowSum[r] = s;                       // each task: its own cell
		});
		System.out.println(Arrays.stream(rowSum).sum());
	}
}
