public class HashCodes {
    static int hash(String s) {          // = String.hashCode()
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = 31 * h + s.charAt(i);
        }
        return h;
    }

    public static void main(String[] args) {
        String[] words = {"a", "ab", "java", "Aa", "BB", "Yeditepe"};
        for (String s : words) {
            int h1 = s.hashCode(), h2 = hash(s);
            System.out.printf("%-9s %12d %12d%n", s, h1, h2);
        }
    }
}
