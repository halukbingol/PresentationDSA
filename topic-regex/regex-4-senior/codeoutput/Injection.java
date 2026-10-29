import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Injection {
    public static void main(String[] args) {
        String text = "price: 5.0 or 5x0";
        String user = "5.0";                       // typed by a user
        System.out.println(text.replaceAll(user, "#"));
        System.out.println(text.replaceAll(Pattern.quote(user), "#"));
        System.out.println(Pattern.quote(user));

        String amount = "$5";                      // also typed by a user
        try {
            System.out.println(text.replaceAll("5\\.0", amount));
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        System.out.println(text.replaceAll("5\\.0", Matcher.quoteReplacement(amount)));
    }
}
