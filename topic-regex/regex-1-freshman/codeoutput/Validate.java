import java.util.Scanner;

public class Validate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String postcode;
        do {
            System.out.print("Postal code (5 digits): ");
            postcode = in.nextLine().trim();
        } while (!postcode.matches("\\d{5}"));
        System.out.println("OK: " + postcode);
    }
}
