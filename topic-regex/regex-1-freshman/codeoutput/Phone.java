public class Phone {
    static final String MOBILE = "05\\d{9}";

    public static void main(String[] args) {
        String[] inputs = { "05321234567", "5321234567", "0532 123 45 67", "053212345678" };
        for (String phone : inputs) {
            System.out.println(phone + " -> " + phone.matches(MOBILE));
        }
        String cleaned = "0532 123 45 67".replaceAll("\\s", "");
        System.out.println(cleaned + " -> " + cleaned.matches(MOBILE));
    }
}
