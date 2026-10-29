public class Quantifiers {
    static void check(String input, String regex) {
        System.out.printf("%-8s %-10s %b%n", input, regex, input.matches(regex));
    }

    public static void main(String[] args) {
        check("", "a*");
        check("aaa", "a*");
        check("", "a+");
        check("a", "a+");
        check("color", "colou?r");
        check("colour", "colou?r");
        check("ab", "a{2,3}");
        check("aab", "a{2,3}b");
        check("aaaab", "a{2,3}b");
    }
}
