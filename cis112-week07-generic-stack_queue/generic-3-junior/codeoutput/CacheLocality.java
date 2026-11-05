import java.util.LinkedList;

public class CacheLocality {
    public static void main(String[] args) {
        int n = 1_000_000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;

        long t0 = System.nanoTime();
        long s1 = 0;
        for (int i = 0; i < n; i++) s1 += arr[i];
        long t1 = System.nanoTime();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) list.add(i);
        long t2 = System.nanoTime();
        long s2 = 0;
        for (int x : list) s2 += x;
        long t3 = System.nanoTime();

        System.out.println("int[]      : " + (t1 - t0) / 1_000_000 + " ms, sum = " + s1);
        System.out.println("LinkedList : " + (t3 - t2) / 1_000_000 + " ms, sum = " + s2);
    }
}