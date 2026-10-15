public class Reverse {
    static String reverse(String word) {
        ArrayStack<Character> s = new ArrayStack<>();
        for (char c : word.toCharArray()) s.push(c);     // push every letter
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) sb.append(s.pop());         // pop them all
        return sb.toString();
    }

    public static void main(String[] args) {
        for (String w : new String[] {"stack", "Yeditepe", "kayak", "çiçek"}) {
            System.out.println(w + " -> " + reverse(w));
        }
    }
}
