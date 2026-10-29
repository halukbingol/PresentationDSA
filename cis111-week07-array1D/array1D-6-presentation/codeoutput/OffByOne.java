public class OffByOne {
	public static void main(String[] args) {
		int[] marks = {10, 20, 30};
		int sum = 0;
		for (int i = 1; i <= marks.length; i++) {
			sum = sum + marks[i];
		}
		System.out.println(sum);
	}
}
