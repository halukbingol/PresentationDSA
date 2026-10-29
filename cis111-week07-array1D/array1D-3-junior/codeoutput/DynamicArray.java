import java.util.Arrays;

/** An int array that grows when it is full. */
public class DynamicArray {
	private int[] data = new int[2];
	private int size = 0;

	private void makeRoom() {
		if (size == data.length) {
			data = Arrays.copyOf(data, 2 * data.length);   // double
		}
	}

	void add(int value) {
		makeRoom();
		data[size] = value;
		size++;
	}

	void insert(int index, int value) {
		makeRoom();
		System.arraycopy(data, index, data, index + 1, size - index);
		data[index] = value;
		size++;
	}

	void remove(int index) {
		System.arraycopy(data, index + 1, data, index, size - index - 1);
		size--;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(data, size))
				+ "  size " + size + ", capacity " + data.length;
	}

	public static void main(String[] args) {
		DynamicArray list = new DynamicArray();
		for (int v = 10; v <= 50; v += 10) {
			list.add(v);
			System.out.println(list);
		}
		list.insert(1, 15);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
	}
}
