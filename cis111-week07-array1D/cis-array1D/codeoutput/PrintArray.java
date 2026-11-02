import java.util.Arrays;
public class PrintArray {
	public static void main(String[] args) {
		int[] marks = {10, 20, 30};
		System.out.println(marks);      // not the elements!
		for (int i = 0; i < marks.length; i++) {
			System.out.print(marks[i] + ", ");
		}
		System.out.println();           // one comma too many
		for (int i = 0; i < marks.length; i++) {
			if (i > 0) {
				System.out.print(", "); // not before [0]
			}
			System.out.print(marks[i]);
		}
		System.out.println();
		System.out.println(Arrays.toString(marks));
	}
}
