import java.util.InputMismatchException;
import java.util.Scanner;

public class InputFixed {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			try {
				int age = in.nextInt();
				System.out.println("age " + age);
				return;
			} catch (InputMismatchException e) {
				System.out.println("not a number: " + in.next());
			}
		}
	}
}
