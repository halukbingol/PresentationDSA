import java.util.Locale;

public class Format {
    public static void main(String[] args) {
        String name = "Ayşe";
        int n = 6;
        double gpa = 3.4567;
        String s = String.format("%s has %d credits", name, n);
        System.out.println(s);
        System.out.println(String.format("GPA: %.2f", gpa));
        Locale tr = Locale.forLanguageTag("tr");
        System.out.println(String.format(tr, "GPA: %.2f", gpa));
        System.out.printf("[%-8s][%8s]%n", name, name);
        System.out.printf("[%5d][%05d]%n", n, n);
        System.out.println("%s: %.1f%%".formatted("rate", 87.25));
    }
}
