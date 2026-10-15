public class Report {
    public static void main(String[] args) {
        // machine-readable output formatted with the DEFAULT locale: a bug
        System.out.println(String.format("%s,%.2f,%d", "tea", 12.5, 3));
    }
}
