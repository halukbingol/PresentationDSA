public class First {
    public static void main(String[] args) {
        String date = "\\d{4}-\\d{2}-\\d{2}";
        System.out.println("2026-10-26".matches(date));
        System.out.println("26.10.2026".matches(date));
        System.out.println("Today: 2026-10-26".replaceAll(date, "<date>"));
    }
}
