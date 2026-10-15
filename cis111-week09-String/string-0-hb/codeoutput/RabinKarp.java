public class RabinKarp {
    static final long B = 256, Q = 1_000_000_007L;     // base, prime modulus

    static int search(String t, String p) {            // first match or -1
        int n = t.length(), m = p.length();
        if (m > n) return -1;
        long hp = 0, ht = 0, pow = 1;                   // pow = B^(m-1) mod Q
        for (int i = 0; i < m; i++) {
            hp = (hp * B + p.charAt(i)) % Q;
            ht = (ht * B + t.charAt(i)) % Q;
            if (i > 0) pow = pow * B % Q;
        }
        for (int s = 0; ; s++) {
            if (hp == ht && t.regionMatches(s, p, 0, m)) return s;   // verify
            if (s + m >= n) return -1;
            ht = (ht - t.charAt(s) * pow % Q + Q) % Q;  // drop left char
            ht = (ht * B + t.charAt(s + m)) % Q;        // add right char
        }
    }

    public static void main(String[] args) {
        String t = "yeditepe university";
        System.out.println(search(t, "tepe"));
        System.out.println(search(t, "versi"));
        System.out.println(search(t, "java"));
    }
}
