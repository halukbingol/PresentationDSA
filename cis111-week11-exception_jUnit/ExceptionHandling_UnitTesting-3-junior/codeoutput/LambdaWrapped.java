import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LambdaWrapped {
	public static void main(String[] args) {
		List<String> names = List.of("scores.txt", "missing.txt");
		try {
			names.forEach(n -> System.out.println(n + ": " + size(n) + " bytes"));
		} catch (UncheckedIOException e) {
			System.out.println("failed: " + e.getCause());
		}
	}

	static long size(String name) {
		try {
			return Files.size(Path.of(name));
		} catch (IOException e) {
			throw new UncheckedIOException(e);   // keeps the cause
		}
	}
}
