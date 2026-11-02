public class PartiallyFilled {
	static void show(int[] a, int size) {
		System.out.print(size + " used:");
		for (int i = 0; i < size; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] values = new int[8];
		int size = 0;
		values[size] = 40; size++;
		values[size] = 15; size++;
		values[size] = 27; size++;
		show(values, size);
		for (int i = size; i > 1; i--) {
			values[i] = values[i - 1];
		}
		values[1] = 33; size++;
		show(values, size);
		for (int i = 0; i < size - 1; i++) {
			values[i] = values[i + 1];
		}
		size--;
		show(values, size);
	}
}
