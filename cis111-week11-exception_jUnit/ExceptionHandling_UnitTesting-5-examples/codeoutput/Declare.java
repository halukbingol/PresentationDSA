import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Declare {
	public static void main(String[] args) {
		try {
			System.out.println(firstLine("scores.txt"));
			System.out.println(firstLine("missing.txt"));
		} catch (FileNotFoundException e) {   // handled
			System.out.println("main: cannot read the file");
		}
	}

	static String firstLine(String name)
			throws FileNotFoundException {     // declared
		try (Scanner in = new Scanner(new File(name))) {
			return in.nextLine();
		}
	}
}
