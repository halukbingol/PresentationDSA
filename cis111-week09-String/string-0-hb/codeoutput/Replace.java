public class Replace {
    public static void main(String[] args) {
        String s = "banana";
        System.out.println(s.replace('a', 'o'));
        System.out.println(s.replace("an", "AN"));
        System.out.println(s.replaceFirst("an", "_"));
        String phone = "0 (212) 555-0123";
        // regex [^0-9]: any character that is not a digit
        System.out.println(phone.replaceAll("[^0-9]", ""));
        System.out.println("ab".repeat(3));
        System.out.println("-".repeat(20));
        System.out.println(s);  // unchanged!
    }
}
