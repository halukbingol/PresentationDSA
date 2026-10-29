public class PartiallyFilled {
	static void show(int[] a, int size) {
		System.out.print(size + " of " + a.length + ":");
		for (int i = 0; i < size; i++) {   // to size
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] values = new int[8];
		int size = 0;
		values[size] = 40; size++;         // add at the end
		values[size] = 15; size++;
		values[size] = 27; size++;
		show(values, size);

		for (int i = size; i > 1; i--) {   // insert at 1:
			values[i] = values[i - 1];     // shift right
		}
		values[1] = 33; size++;
		show(values, size);

		for (int i = 0; i < size - 1; i++) {  // remove 0,
			values[i] = values[i + 1];     // keep the order
		}
		size--;
		show(values, size);

		values[0] = values[size - 1];      // remove 0,
		size--;                            // any order
		show(values, size);
	}
}
