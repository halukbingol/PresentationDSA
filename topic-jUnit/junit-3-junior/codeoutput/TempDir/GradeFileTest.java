import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class GradeFileTest {
    @TempDir
    Path dir;

    @Test
    void writesAndReadsBack() throws IOException {
        Path file = dir.resolve("cis111.csv");
        GradeFile.save(file, List.of("Ayşe, 90", "Ali, 75"));

        assertTrue(Files.exists(file));
        assertEquals(82.5, GradeFile.average(file), 1e-9);
    }

    @Test
    void missingFileIsAnError() {
        assertThrows(IOException.class, () -> GradeFile.average(dir.resolve("none.csv")));
    }
}
