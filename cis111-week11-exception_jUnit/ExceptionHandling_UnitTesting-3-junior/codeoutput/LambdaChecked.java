import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LambdaChecked {
	public static void main(String[] args) {
		List<String> names = List.of("a.txt", "b.txt");
		names.forEach(n -> System.out.println(Files.size(Path.of(n))));
	}
}
