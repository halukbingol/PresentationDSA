import java.util.Locale;

public class Receipt {
    public static void main(String[] args) {
        double price = 1249.9;
        Locale tr = Locale.of("tr", "TR");
        System.out.printf(Locale.US, "for a file:   %.2f%n", price);   // always a point
        System.out.printf(tr, "for a person: %,.2f TL%n", price);      // Turkish style
        System.out.printf("default:      %,.2f%n", price);             // the computer decides
    }
}
