public class Anatomy {
	public static void main(String[] args) {
		int[] ages = {19, 21, 18, 20, 22};
		int last = ages.length - 1;

		System.out.println("length " + ages.length);
		System.out.println("first  " + ages[0]);
		System.out.println("last   " + ages[last]
				+ " at index " + last);
		for (int i = 0; i < ages.length; i++) {
			System.out.print(i + ":" + ages[i] + "  ");
		}
		System.out.println();
	}
}
