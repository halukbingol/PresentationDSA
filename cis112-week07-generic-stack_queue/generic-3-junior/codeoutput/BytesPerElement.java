public class BytesPerElement {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        int n = 1_000_000;
        long base = used(r);
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = Integer.valueOf(i);
        long withInts = used(r) - base;
        System.out.println("n = " + n);
        System.out.println("Integer[]: ~" + withInts / n + " bytes / element");
        System.out.println("int[]    :     4 bytes / element (plus header)");
        System.out.println("(kept alive: " + a.length + ")");
    }
    static long used(Runtime r) {
        System.gc();
        return r.totalMemory() - r.freeMemory();
    }
}