public class Replace {
    public static void main(String[] args) {
        String text = "Merhaba    dünya,   nasılsın?";
        System.out.println(text.replaceAll("\\s+", " "));

        String phone = "0532 123 45 67";
        System.out.println(phone.replaceAll("\\d(?=(?:\\D*\\d){2})", "*"));

        String date = "19.10.2026";
        System.out.println(date.replaceAll("(\\d{2})\\.(\\d{2})\\.(\\d{4})", "$3-$2-$1"));

        String code = "cis111, CIS112 and cse 101";
        System.out.println(code.replaceAll("[a-z]", "?"));
        System.out.println(code.replaceFirst("\\d+", "###"));
    }
}
