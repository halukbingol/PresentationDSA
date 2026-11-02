import java.util.Arrays;
public class DeepLib {
	public static void main(String[] args) {
		int[][] a = {{1, 2}, {3, 4}};
		int[][] b = {{1, 2}, {3, 4}};
		System.out.println(a == b);
		System.out.println(Arrays.equals(a, b));
		System.out.println(Arrays.deepEquals(a, b));
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.deepToString(a));
	}
}
