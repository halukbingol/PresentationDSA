import java.util.ArrayDeque;

public class Nesting {
    static int pos;

    /** recursive descent: a group is "(" group* ")" */
    static int depthRecursive(String s) {
        pos++;                                          // skip "("
        int max = 0;
        while (s.charAt(pos) == '(') max = Math.max(max, depthRecursive(s));
        pos++;                                          // skip ")"
        return max + 1;
    }

    static int depthWithStack(String s, int limit) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
                if (st.size() > limit) throw new IllegalArgumentException("nesting deeper than " + limit);
                max = Math.max(max, st.size());
            } else st.pop();
        }
        return max;
    }

    public static void main(String[] args) {
        String evil = "(".repeat(100_000) + ")".repeat(100_000);     // 200 KB of input
        System.out.println("with a stack:     " + depthWithStack(evil, Integer.MAX_VALUE));
        try {
            depthWithStack(evil, 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("with a limit:     " + e.getMessage());
        }
        try {
            pos = 0;
            System.out.println("recursive:        " + depthRecursive(evil));
        } catch (StackOverflowError e) {
            System.out.println("recursive:        StackOverflowError: the parser (and maybe the server) is down");
        }
    }
}
