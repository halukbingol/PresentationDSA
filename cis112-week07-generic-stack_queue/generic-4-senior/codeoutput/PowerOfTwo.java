public class PowerOfTwo {
    public static void main(String[] args) {
        int n = Integer.parseInt(args.length > 0 ? args[0] : "1024");
        if ((n & (n - 1)) != 0) { System.out.println("not a power of two"); return; }
        int mask = n - 1;

        long t0 = System.nanoTime();
        long s1 = 0;
        for (int i = 0; i < 100_000_000; i++) s1 += (i * 31 + 7) % n;
        long t1 = System.nanoTime();

        long s2 = 0;
        for (int i = 0; i < 100_000_000; i++) s2 += (i * 31 + 7) & mask;
        long t2 = System.nanoTime();

        System.out.println("n = " + n + ", mask = " + mask);
        System.out.println("mod: " + (t1 - t0) / 1_000_000 + " ms, sum=" + s1);
        System.out.println("and: " + (t2 - t1) / 1_000_000 + " ms, sum=" + s2);
        System.out.println("same result: " + (s1 == s2));
    }
}