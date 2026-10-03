public class Timing {
    static String plus(int n) {
        String s = "";
        for (int i = 0; i < n; i++) s += "x";        // copies s each time
        return s;
    }
    static String builder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("x");  // amortized O(1)
        return sb.toString();
    }
    public static void main(String[] args) {
        plus(20_000); builder(20_000);                 // warm up the JIT
        for (int n = 20_000; n <= 160_000; n *= 2) {
            long t0 = System.nanoTime();
            String a = plus(n);
            long t1 = System.nanoTime();
            String b = builder(n);
            long t2 = System.nanoTime();
            System.out.printf("n=%6d  +=%7.1f ms  builder=%5.2f ms  same=%b%n",
                    n, (t1 - t0) / 1e6, (t2 - t1) / 1e6, a.equals(b));
        }
    }
}
