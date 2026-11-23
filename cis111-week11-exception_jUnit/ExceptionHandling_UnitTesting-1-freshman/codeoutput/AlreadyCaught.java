import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AlreadyCaught {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("scores.txt"));
			System.out.println(in.nextLine());
		} catch (IOException e) {
			System.out.println("cannot read");
		} catch (FileNotFoundException e) {
			System.out.println("no such file");
		}
	}
}
