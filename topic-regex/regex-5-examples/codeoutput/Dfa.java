public class Dfa {
    // states 0..3 for (a|b)*abb; NEXT[state][0] on 'a', NEXT[state][1] on 'b'
    static final int[][] NEXT = { { 1, 0 }, { 1, 2 }, { 1, 3 }, { 1, 0 } };

    static boolean accepts(String text) {
        int q = 0;
        StringBuilder trace = new StringBuilder("q0");
        for (char c : text.toCharArray()) {
            q = NEXT[q][c == 'a' ? 0 : 1];
            trace.append(" -").append(c).append("-> q").append(q);
        }
        System.out.printf("%-6s %s%n", text, trace);
        return q == 3;
    }

    public static void main(String[] args) {
        for (String s : new String[] { "abb", "babb", "abab", "aabbabb" }) {
            System.out.println("       accepted: " + accepts(s));
        }
    }
}
