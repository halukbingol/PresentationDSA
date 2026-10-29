public class Re2 {
    static void time(String name, java.util.function.BooleanSupplier match) {
        long t0 = System.nanoTime();
        boolean found;
        try {
            found = match.getAsBoolean();
        } catch (StackOverflowError e) {
            System.out.printf("%-26s StackOverflowError%n", name);
            return;
        }
        System.out.printf("%-26s %-5b %4d ms%n", name, found, (System.nanoTime() - t0) / 1_000_000);
    }

    public static void main(String[] args) {
        String csv = "1,".repeat(27) + "1";
        String lazy = "^(.*?,){11}P.*";
        time("java.util.regex  CSV", () -> java.util.regex.Pattern.matches(lazy, csv));
        time("RE2/J            CSV", () -> com.google.re2j.Pattern.matches(lazy, csv));

        String ab = "ab".repeat(20_000);
        time("java.util.regex  (a|b)*", () -> java.util.regex.Pattern.matches("(a|b)*", ab));
        time("RE2/J            (a|b)*", () -> com.google.re2j.Pattern.matches("(a|b)*", ab));

        try {
            com.google.re2j.Pattern.compile("(a+)\\1");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
