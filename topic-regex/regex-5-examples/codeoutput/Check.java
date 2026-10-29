import java.util.Scanner;
import java.util.regex.Pattern;

public class Check {
    static final Pattern NUMBER = Pattern.compile("20\\d{2}11\\d{5}");
    static final Pattern MAIL = Pattern.compile("[a-z0-9._]+@std\\.yeditepe\\.edu\\.tr");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String number = in.next(), mail = in.next();
            System.out.printf("%-12s %-5b %-28s %b%n", number, NUMBER.matcher(number).matches(),
                    mail, MAIL.matcher(mail).matches());
        }
    }
}
