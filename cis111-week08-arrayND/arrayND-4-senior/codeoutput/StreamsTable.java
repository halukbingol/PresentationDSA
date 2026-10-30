import java.util.Arrays;
public class StreamsTable {
	public static void main(String[] args) {
		int[][] s = {{72, 85, 90, 64},
		             {55, 61, 70, 80},
		             {90, 88, 93, 99}};
		int[] totals = Arrays.stream(s)
				.mapToInt(row -> Arrays.stream(row).sum())
				.toArray();
		int all = Arrays.stream(s).flatMapToInt(Arrays::stream).sum();
		int best = Arrays.stream(s).flatMapToInt(Arrays::stream).max().getAsInt();
		System.out.println(Arrays.toString(totals));
		System.out.println(all + " " + best);
	}
}
