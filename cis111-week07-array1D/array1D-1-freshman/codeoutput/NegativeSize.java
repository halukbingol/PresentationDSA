public class NegativeSize {
	public static void main(String[] args) {
		int students = 3 - 5;          // a size computed wrongly
		int[] marks = new int[students];
		System.out.println(marks.length);
	}
}
