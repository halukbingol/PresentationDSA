import java.util.ResourceBundle;
import java.util.Scanner;

public class Greeter {
    public static void main(String[] args) {
        ResourceBundle text = ResourceBundle.getBundle("Texts"); // default locale
        System.out.print(text.getString("ask") + " ");
        String name = new Scanner(System.in).nextLine();
        System.out.println(text.getString("hello") + ", " + name + "!");
    }
}
