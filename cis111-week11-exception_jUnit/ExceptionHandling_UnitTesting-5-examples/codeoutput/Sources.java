import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sources {
	public static void main(String[] args) {
		int[] scores = {72, 85, 90};
		try {                             // 1. a bug
			System.out.println(scores[scores.length]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("bug:   " + e.getMessage());
		}
		try {                             // 2. the input
			System.out.println(Integer.parseInt("twelve"));
		} catch (NumberFormatException e) {
			System.out.println("input: " + e.getMessage());
		}
		try {                             // 3. the world
			new Scanner(new File("no-such-file.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("world: the file is missing");
		}
	}
}
