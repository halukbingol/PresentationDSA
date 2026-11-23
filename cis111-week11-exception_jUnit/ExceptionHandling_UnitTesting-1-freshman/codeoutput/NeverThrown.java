import java.io.FileNotFoundException;

public class NeverThrown {
	public static void main(String[] args) {
		try {
			System.out.println(Integer.parseInt("42"));
		} catch (FileNotFoundException e) {
			System.out.println("no such file");
		}
	}
}
