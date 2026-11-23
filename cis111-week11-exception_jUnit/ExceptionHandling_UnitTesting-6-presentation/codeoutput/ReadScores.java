import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadScores {
	public static void main(String[] args) {
		printTotal("scores.txt");
		printTotal("score.txt");       // a typo
	}

	static void printTotal(String fileName) {
		try (Scanner in = new Scanner(new File(fileName))) {
			int total = 0;
			while (in.hasNextInt()) {
				total = total + in.nextInt();
			}
			System.out.println(fileName + ": total " + total);
		} catch (FileNotFoundException e) {
			System.out.println("cannot open " + fileName);
		}                              // in is closed here
	}
}
