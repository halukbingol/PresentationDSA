public class LengthCharAt {
    public static void main(String[] args) {
        String s = "Yeditepe";
        System.out.println("length: " + s.length());
        System.out.println("first : " + s.charAt(0));
        System.out.println("last  : " + s.charAt(s.length() - 1));
        for (int i = 0; i < s.length(); i++) {
            System.out.print(i + ":" + s.charAt(i) + " ");
        }
        System.out.println();
        char c = s.charAt(2);
        System.out.println(c + " has code " + (int) c);
    }
}
