import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyUpper {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(new File("names.txt"));
				PrintWriter out = new PrintWriter("NAMES.txt")) {
			while (in.hasNextLine()) {
				out.println(in.nextLine().toUpperCase());
			}
			System.out.println("done");
		} catch (FileNotFoundException e) {
			System.out.println("cannot open: " + e.getMessage());
		}
	}
}
