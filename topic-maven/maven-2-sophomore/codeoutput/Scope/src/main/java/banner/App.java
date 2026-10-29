package banner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.jupiter.api.Assertions;

public class App {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        try (InputStream in = App.class.getResourceAsStream("/app.properties")) {
            p.load(in);
        }
        String text = args.length > 0 ? String.join(" ", args) : "Merhaba Maven";
        System.out.println(Banner.make(text, 24));
        System.out.println(p.getProperty("name") + " " + p.getProperty("version"));
    }
}
