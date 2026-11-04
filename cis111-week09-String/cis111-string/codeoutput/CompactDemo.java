public class CompactDemo {
    public static void main(String[] args) {
        int n = 1_000_000;
        String[] keep = new String[n];
        Runtime rt = Runtime.getRuntime();
        System.gc();
        long before = rt.totalMemory() - rt.freeMemory();
        for (int i = 0; i < n; i++) {
            keep[i] = ("student-" + (10_000_000 + i)).repeat(2); // 32 chars
        }
        System.gc();
        long after = rt.totalMemory() - rt.freeMemory();
        System.out.printf("%d x %d chars: %d MB%n",
                n, keep[0].length(), (after - before) >> 20);
    }
}
