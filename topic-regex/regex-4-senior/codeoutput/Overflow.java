import java.util.regex.Pattern;

public class Overflow {
    static void test(String regex, String text) {
        try {
            System.out.println(regex + " " + text.matches(regex));
        } catch (StackOverflowError e) {
            System.out.println(regex + " StackOverflowError");
        }
    }

    public static void main(String[] args) {
        String text = "ab".repeat(20_000);
        test("(a|b)*", text);
        test("[ab]*", text);
        test("(?:a|b)*", text);
        test("(?:ab)*", text);
    }
}
