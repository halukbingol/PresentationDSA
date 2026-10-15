import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/** Writes Messages_en_XA.properties: every text accented, longer and in brackets. */
public class Pseudo {
    static final Map<Character, Character> ACCENT = Map.of(
        'a', 'à', 'e', 'é', 'i', 'ï', 'o', 'ö', 'u', 'ü', 'A', 'Å', 'E', 'É', 'O', 'Ø');

    static String pseudo(String text) {
        StringBuilder b = new StringBuilder("[");
        int depth = 0;                                   // inside {...}: keep as it is
        for (char c : text.toCharArray()) {
            if (c == '{') depth++;
            if (c == '}') depth--;
            b.append(depth == 0 ? ACCENT.getOrDefault(c, c) : c);
        }
        return b.append(" ").append("~".repeat(text.length() / 3)).append("]").toString();
    }
    public static void main(String[] args) throws IOException {
        Path dir = Path.of(args[0]);
        List<String> out = Files.readAllLines(dir.resolve("Messages.properties")).stream()
            .map(l -> l.startsWith("#") || !l.contains("=") ? l
                 : l.substring(0, l.indexOf('=') + 1) + pseudo(l.substring(l.indexOf('=') + 1)))
            .toList();
        Files.write(dir.resolve("Messages_en_XA.properties"), out);
    }
}
