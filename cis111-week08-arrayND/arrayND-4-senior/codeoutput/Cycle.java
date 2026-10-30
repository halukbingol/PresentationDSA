import java.util.Arrays;
public class Cycle {
	public static void main(String[] args) {
		Object[] a = new Object[2];
		a[0] = new int[] {1, 2};
		a[1] = a;                          // a contains itself
		System.out.println(Arrays.deepToString(a));
	}
}
