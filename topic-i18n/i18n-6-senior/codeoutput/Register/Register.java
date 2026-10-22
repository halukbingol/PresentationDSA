import java.util.Scanner;

public class Register {
    public static void main(String[] args) {
        String name = new Scanner(System.in).next();
        if (name.toUpperCase().equals("ADMIN")) {          // BUG: default locale
            System.out.println("rejected: reserved name");
            return;
        }
        System.out.println("created user '" + name + "'");  // on a Turkish server: admin!
    }
}
