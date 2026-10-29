/** A tiny backtracking matcher for c . * ^ $ (after Kernighan and Pike) that prints its steps. */
public class Mini {
    static int steps;

    static boolean match(String re, String text) {
        if (re.startsWith("^")) return here(re.substring(1), text, 0);
        for (int i = 0; i <= text.length(); i++)
            if (here(re, text, i)) return true;
        return false;
    }

    static boolean here(String re, String t, int i) {
        steps++;
        System.out.printf("  try %-5s at %d \"%s\"%n", re, i, t.substring(i));
        if (re.isEmpty()) return true;
        if (re.length() > 1 && re.charAt(1) == '*') return star(re.charAt(0), re.substring(2), t, i);
        if (re.equals("$")) return i == t.length();
        if (i < t.length() && (re.charAt(0) == '.' || re.charAt(0) == t.charAt(i)))
            return here(re.substring(1), t, i + 1);
        return false;
    }

    static boolean star(char c, String rest, String t, int i) {
        int j = i;
        while (j < t.length() && (c == '.' || t.charAt(j) == c)) j++;   // greedy: take all
        for (; j >= i; j--)                                              // then give back
            if (here(rest, t, j)) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("^a*ab$ on aaab:");
        System.out.println(match("^a*ab$", "aaab") + " after " + steps + " steps");
    }
}
