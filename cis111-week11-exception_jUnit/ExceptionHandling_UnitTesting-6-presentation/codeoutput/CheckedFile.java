import java.io.File;
import java.util.Scanner;

public class CheckedFile {
	public static void main(String[] args) {
		Scanner in = new Scanner(new File("scores.txt"));
		System.out.println(in.nextLine());
		in.close();
	}
}
