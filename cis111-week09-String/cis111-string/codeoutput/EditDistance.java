public class EditDistance {
    static int[][] table(String a, String b) {
        int[][] d = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) d[i][0] = i;     // delete all
        for (int j = 0; j <= b.length(); j++) d[0][j] = j;     // insert all
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int sub = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                d[i][j] = Math.min(d[i - 1][j - 1] + sub,          // replace/keep
                          Math.min(d[i - 1][j] + 1,                // delete
                                   d[i][j - 1] + 1));              // insert
            }
        }
        return d;
    }
    public static void main(String[] args) {
        String a = "kitten", b = "sitting";
        int[][] d = table(a, b);
        System.out.println("       " + String.join("  ", b.split("")));
        for (int i = 0; i <= a.length(); i++) {
            System.out.print(i == 0 ? "  " : " " + a.charAt(i - 1));
            for (int j = 0; j <= b.length(); j++) System.out.printf("%3d", d[i][j]);
            System.out.println();
        }
        System.out.println("distance = " + d[a.length()][b.length()]);
    }
}
