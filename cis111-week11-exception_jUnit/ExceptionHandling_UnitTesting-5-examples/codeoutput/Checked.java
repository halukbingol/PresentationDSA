import java.io.FileReader;

public class Checked {
	public static void main(String[] args) {
		FileReader in = new FileReader("scores.txt");   // checked: does not compile
		Integer.parseInt("x");                           // unchecked: compiles
	}
}
