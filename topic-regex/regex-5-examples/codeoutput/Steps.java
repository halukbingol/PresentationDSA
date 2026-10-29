public class Steps {
    static int steps;

    // the matcher of Mini without the printing: c . * only
    static boolean here(String re, String t, int i) {
        steps++;
        if (re.isEmpty()) return i == t.length();
        if (re.length() > 1 && re.charAt(1) == '*') {
            int j = i;
            while (j < t.length() && (re.charAt(0) == '.' || t.charAt(j) == re.charAt(0))) j++;
            for (; j >= i; j--) if (here(re.substring(2), t, j)) return true;
            return false;
        }
        return i < t.length() && (re.charAt(0) == '.' || re.charAt(0) == t.charAt(i))
                && here(re.substring(1), t, i + 1);
    }

    public static void main(String[] args) {
        System.out.println("regex       n=10    n=20    n=30    n=40");
        for (String re : new String[] { "a*c", "a*a*c", "a*a*a*c", "a*a*a*a*c" }) {
            System.out.printf("%-10s", re);
            for (int n = 10; n <= 40; n += 10) {
                steps = 0;
                here(re, "a".repeat(n), 0);          // no c: it must fail
                System.out.printf("%8d", steps);
            }
            System.out.println();
        }
    }
}
