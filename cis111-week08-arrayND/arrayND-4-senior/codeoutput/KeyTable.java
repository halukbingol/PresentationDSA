import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class KeyTable {
	public static void main(String[] args) {
		int[][] a = {{1, 2}, {3, 4}};
		int[][] b = {{1, 2}, {3, 4}};
		Set<int[][]> seen = new HashSet<>();
		seen.add(a);
		System.out.println(seen.contains(b));          // identity!
		System.out.println(a.equals(b));
		System.out.println(Arrays.deepEquals(a, b));
		System.out.println(Arrays.deepHashCode(a) == Arrays.deepHashCode(b));
	}
}
