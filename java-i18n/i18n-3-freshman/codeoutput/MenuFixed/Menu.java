import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String cmd = new Scanner(System.in).next();
        String key = cmd.toUpperCase(Locale.ROOT);   // same on every computer
        System.out.println("key = " + key);
        if (key.equals("QUIT")) System.out.println("Bye.");
        else System.out.println("Unknown command: " + cmd);
    }
}
