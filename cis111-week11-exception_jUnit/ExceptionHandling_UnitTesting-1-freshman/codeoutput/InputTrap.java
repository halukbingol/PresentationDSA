import java.util.InputMismatchException;
import java.util.Scanner;

public class InputTrap {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tries = 0;
		while (tries < 4) {          // stop after 4
			tries++;
			try {
				int age = in.nextInt();
				System.out.println("age " + age);
				return;
			} catch (InputMismatchException e) {
				System.out.println("not a number, again:");
			}
		}
		System.out.println("4 tries, same word");
	}
}
