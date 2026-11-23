public class MemoryLayout {
    public static void main(String[] args) {
        long mb = 1024L * 1024;
        int n = 1_000_000;
        Runtime r = Runtime.getRuntime();

        long b0 = used(r);
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        long b1 = used(r) - b0;

        System.out.println("n = " + n);
        System.out.println("Integer[]: ~" + b1 / n + " bytes / element");
        System.out.println("free memory: ~" + r.freeMemory() / mb + " MB");
    }
    static long used(Runtime r) { System.gc(); return r.totalMemory() - r.freeMemory(); }
}
