public class Busy {
    static long work(int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) sum += i % 7;
        return sum;
    }

    public static void main(String[] args) {
        long total = 0;
        long end = System.currentTimeMillis() + 3_000;   // run for 3 s
        while (System.currentTimeMillis() < end) {
            total += work(1_000_000);
        }
        System.out.println("done " + total);
    }
}
