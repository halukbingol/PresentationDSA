import java.util.Scanner;

public class AskAgain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int score = 0;
		boolean done = false;
		while (!done) {
			System.out.println("Type a score:");
			String line = in.nextLine();
			try {
				score = Integer.parseInt(line);
				done = true;
			} catch (NumberFormatException e) {
				System.out.println("  not a number: " + line);
			}
		}
		System.out.println("score " + score + " accepted");
	}
}
