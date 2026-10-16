import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Banner {
    public static void main(String[] args) throws IOException {
        // 1. a resource: searched on the class path
        try (InputStream in = Banner.class.getResourceAsStream("/banner.txt")) {
            System.out.print("resource: " + new String(in.readAllBytes()));
        }
        // 2. a file: relative to the CURRENT folder
        Path p = Path.of("banner.txt");
        String f = Files.exists(p) ? Files.readString(p).strip() : "not found";
        System.out.println("file    : " + f);
    }
}
