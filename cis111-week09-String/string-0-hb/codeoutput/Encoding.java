import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Encoding {
    public static void main(String[] args) {
        String s = "Ağaç";
        for (String cs : new String[] {"UTF-8", "ISO-8859-9", "UTF-16BE"}) {
            byte[] b = s.getBytes(Charset.forName(cs));
            StringBuilder hex = new StringBuilder();
            for (byte x : b) hex.append(String.format("%02X ", x));
            System.out.printf("%-10s %d bytes: %s%n", cs, b.length, hex);
        }
        byte[] utf8 = s.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(utf8, Charset.forName("windows-1252")));  // wrong
        System.out.println(new String(utf8, StandardCharsets.UTF_8));             // right
        System.out.println("default charset: " + Charset.defaultCharset());
    }
}
