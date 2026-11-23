import java.io.File;
import java.util.Scanner;

public class CatchAll {
	public static void main(String[] args) {
		String name = null;                       // a bug: the name was never set
		try {
			Scanner in = new Scanner(new File(name));
			System.out.println(in.nextLine());
		} catch (Exception e) {                    // catches everything ...
			System.out.println("Could not read the file. Is it there?");
		}
	}
}
