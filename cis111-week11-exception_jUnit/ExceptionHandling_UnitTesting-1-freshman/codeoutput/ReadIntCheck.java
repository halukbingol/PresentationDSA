import java.util.Scanner;

public class ReadIntCheck {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Your age:");
		while (!in.hasNextInt()) {
			String word = in.next();     // take it away
			System.out.println("  not a number: " + word);
		}
		int age = in.nextInt();
		System.out.println("age " + age);
	}
}
