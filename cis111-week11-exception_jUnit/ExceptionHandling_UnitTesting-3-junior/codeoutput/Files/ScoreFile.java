import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScoreFile {

	/** The total of the numbers in the file, one per line. */
	public static int total(Path file) throws IOException {
		int sum = 0;
		for (String line : Files.readAllLines(file)) {
			sum += Integer.parseInt(line.trim());
		}
		return sum;
	}
}
