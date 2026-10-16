import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Bytes {
    public static void main(String[] args) {
        String s = "ağaç";
        for (String cs : new String[] {"UTF-8", "ISO-8859-9", "UTF-16BE"}) {
            StringBuilder hex = new StringBuilder();
            for (byte b : s.getBytes(Charset.forName(cs)))
                hex.append(String.format("%02X ", b));
            System.out.printf("%-10s %s%n", cs, hex);
        }
        byte[] utf8 = s.getBytes(StandardCharsets.UTF_8);
        System.out.println("read as Windows-1252: " + new String(utf8, Charset.forName("windows-1252")));
        System.out.println("read as UTF-8:        " + new String(utf8, StandardCharsets.UTF_8));
    }
}
