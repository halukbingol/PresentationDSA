public class Table {
    public static void main(String[] args) {
        String[] regexes = { "cat", "c.t", "ca*t", "ca+t", "ca?t", "[0-9]{4}", "cat|dog" };
        String[] texts = { "cat", "ct", "caat", "cut", "2026", "dog" };
        System.out.printf("%-9s", "");
        for (String t : texts) System.out.printf("%-6s", t);
        System.out.println();
        for (String r : regexes) {
            System.out.printf("%-9s", r);
            for (String t : texts) System.out.printf("%-6s", t.matches(r) ? "yes" : ".");
            System.out.println();
        }
    }
}
