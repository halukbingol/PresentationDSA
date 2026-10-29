public class Matches {
    static void check(String input, String regex) {
        System.out.printf("%-12s %-14s %b%n", input, regex, input.matches(regex));
    }

    public static void main(String[] args) {
        check("cat", "cat");
        check("cat", "c.t");
        check("cut", "c.t");
        check("ct", "c.t");
        check("2026", "[0-9]{4}");
        check("20a6", "[0-9]{4}");
        check("34755", "\\d{5}");
        check("Ayşe", "[A-Z].*");
        check("ayşe", "[A-Z].*");
    }
}
