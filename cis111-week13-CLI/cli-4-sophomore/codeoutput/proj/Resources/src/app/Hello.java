package app;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Hello {
    public static void main(String[] args) throws IOException {
        // looked up on the classpath, next to Hello.class: app/greeting.txt
        try (InputStream in = Hello.class.getResourceAsStream("greeting.txt")) {
            String text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            System.out.print(text);
        }
    }
}
