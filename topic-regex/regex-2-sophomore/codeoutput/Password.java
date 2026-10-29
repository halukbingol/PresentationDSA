public class Password {
    static final String STRONG = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^A-Za-z0-9]).{8,}";

    public static void main(String[] args) {
        String[] tries = { "yeditepe", "Yeditepe2026", "Yedi!26", "Yeditepe!2026" };
        System.out.println("password      digit lower upper sym.  strong");
        for (String p : tries) {
            System.out.printf("%-13s %-5b %-5b %-5b %-5b %b%n", p,
                    p.matches(".*\\d.*"), p.matches(".*[a-z].*"), p.matches(".*[A-Z].*"),
                    p.matches(".*[^A-Za-z0-9].*"), p.matches(STRONG));
        }
    }
}
