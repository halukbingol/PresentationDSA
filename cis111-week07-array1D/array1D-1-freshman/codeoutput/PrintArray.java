public class PrintArray {
	public static void main(String[] args) {
		int[] marks = {10, 20, 30};
		System.out.println(marks);     // not the elements!

		for (int i = 0; i < marks.length; i++) {
			System.out.print(marks[i] + " ");
		}
		System.out.println();

		char[] word = {'J', 'a', 'v', 'a'};
		System.out.println(word);      // char[]: special
	}
}
