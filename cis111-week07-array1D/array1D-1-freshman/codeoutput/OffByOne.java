public class OffByOne {
	public static void main(String[] args) {
		int[] marks = {10, 20, 30};
		for (int i = 0; i <= marks.length; i++) {
			System.out.println(i + ": " + marks[i]);
		}
	}
}
