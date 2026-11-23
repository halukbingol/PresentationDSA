import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ScoreFileTest {
	@TempDir
	Path dir;                                       // a new, empty folder for every test

	@Test
	void total() throws IOException {
		Path file = dir.resolve("scores.txt");
		Files.write(file, List.of("72", " 85 ", "90"));
		assertEquals(247, ScoreFile.total(file));
	}

	@Test
	void emptyFile() throws IOException {
		Path file = Files.createFile(dir.resolve("empty.txt"));
		assertEquals(0, ScoreFile.total(file));
	}

	@Test
	void missingFile() {
		assertThrows(NoSuchFileException.class, () -> ScoreFile.total(dir.resolve("none.txt")));
	}

	@Test
	void badLine() throws IOException {
		Path file = dir.resolve("bad.txt");
		Files.write(file, List.of("72", "8S"));
		assertThrows(NumberFormatException.class, () -> ScoreFile.total(file));
	}
}
