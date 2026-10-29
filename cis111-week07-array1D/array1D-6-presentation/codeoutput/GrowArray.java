import java.util.Arrays;

public class GrowArray {
	public static void main(String[] args) {
		int[] values = {40, 15, 27};           // full: length 3
		int size = values.length;
		if (size == values.length) {           // no room left:
			values = Arrays.copyOf(values, 2 * values.length);
		}                                      // a new, longer array
		values[size] = 33;
		size++;
		System.out.println(Arrays.toString(values));
		System.out.println("size " + size + " of " + values.length);
	}
}
