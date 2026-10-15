import java.util.Locale;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.ROOT);  // '.' always
        System.out.print("Two numbers: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        System.out.println("Average: " + (a + b) / 2);
    }
}
