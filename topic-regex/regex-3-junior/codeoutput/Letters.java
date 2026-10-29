import java.util.regex.Pattern;

public class Letters {
    static void row(String word) {
        System.out.printf("%-9s %-6b %-6b %-6b %-6b%n", word,
                word.matches("[a-zA-Z]+"),
                word.matches("\\w+"),
                word.matches("\\p{L}+"),
                Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS).matcher(word).matches());
    }

    public static void main(String[] args) {
        System.out.println("word      [a-zA-Z] \\w     \\p{L} \\w+U");
        row("Ankara");
        row("Iğdır");
        row("Şişli");
        row("Ömer");
        row("İzmir");
    }
}
