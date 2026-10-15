import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = 0, words = 0, chars = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            lines++;
            chars += line.length();
            if (!line.isBlank()) {
                words += line.strip().split("\\s+").length;
            }
        }
        System.out.println(lines + " lines, " + words + " words, "
                + chars + " chars");
    }
}
