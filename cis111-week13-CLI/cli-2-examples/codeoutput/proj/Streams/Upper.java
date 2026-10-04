import java.util.Locale;
import java.util.Scanner;

public class Upper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line.toUpperCase(Locale.ROOT));
            lines++;
        }
        System.err.println(lines + " lines converted");
    }
}
