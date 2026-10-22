import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GradeFile {
    public static void save(Path file, List<String> lines) throws IOException {
        Files.write(file, lines);
    }

    public static double average(Path file) throws IOException {
        return Files.readAllLines(file).stream()
                .mapToInt(line -> Integer.parseInt(line.split(",")[1].trim()))
                .average().orElse(0);
    }
}
