public class CharClass {
    public static void main(String[] args) {
        String s = "Ders 101: Java & Strings!";
        int letters = 0, digits = 0, spaces = 0, others = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) letters++;
            else if (Character.isDigit(c)) digits++;
            else if (Character.isWhitespace(c)) spaces++;
            else others++;
        }
        System.out.println("letters: " + letters);
        System.out.println("digits : " + digits);
        System.out.println("spaces : " + spaces);
        System.out.println("others : " + others);
        System.out.println(Character.toUpperCase('ş'));
        System.out.println(Character.isLetter('ğ'));
        System.out.println('7' - '0' + 1);
    }
}
