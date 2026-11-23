import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDemo {
	public static void main(String[] args) {
		System.setProperty("java.util.logging.SimpleFormatter.format",
				"%4$s %3$s: %5$s%6$s%n");              // level, logger, message, exception
		Logger log = Logger.getLogger("grades");
		log.info("reading scores");
		try (Scanner in = new Scanner(new File("missing.txt"))) {
			log.info("first line: " + in.nextLine());
		} catch (FileNotFoundException e) {
			log.log(Level.WARNING, "no scores file, using none", e);
		}
	}
}
