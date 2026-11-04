public class Spell {
    public static void main(String[] args) {
        String word = "Java";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            System.out.println("index " + i + ": " + c);
        }
        for (char c : word.toCharArray()) {   // for-each
            System.out.print(c + "-");
        }
        System.out.println();
    }
}
