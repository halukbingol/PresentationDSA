import java.util.Locale;

public class Default {
    public static void main(String[] args) {
        System.out.println("default locale: " + Locale.getDefault());
        System.out.printf("pi = %.2f, big = %,d%n", Math.PI, 1234567);
        System.out.println(String.format(Locale.ROOT, "fixed: %.2f", Math.PI));
    }
}
