import java.util.Arrays;
public class ShallowCopy {
	public static void main(String[] args) {
		int[][] a = {{1, 2}, {3, 4}};
		int[][] c1 = a.clone();
		int[][] c2 = Arrays.copyOf(a, a.length);
		System.out.println(c1 == a);          // new outer array
		System.out.println(c1[0] == a[0]);    // same row
		c2[1][1] = 99;
		System.out.println(a[1][1]);         // seen through a
	}
}
