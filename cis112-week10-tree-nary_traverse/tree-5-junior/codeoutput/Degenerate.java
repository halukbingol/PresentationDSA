import java.util.*;

public class Degenerate {
    public static void main(String[] args) {
        Random rnd = new Random(2026);
        System.out.printf("%9s %10s %8s %8s %8s%n", "n", "log2(n)", "sorted", "random", "AVL");
        for (int n = 1_000; n <= 100_000; n *= 10) {
            List<Integer> keys = new ArrayList<>();
            for (int i = 0; i < n; i++) keys.add(i);

            PlainBst sorted = new PlainBst();
            for (int k : keys) sorted.insert(k);           // 0, 1, 2, ...

            Collections.shuffle(keys, rnd);
            PlainBst random = new PlainBst();
            for (int k : keys) random.insert(k);

            Avl avl = new Avl();
            for (int i = 0; i < n; i++) avl.insert(i);     // sorted again!

            System.out.printf("%,9d %10.1f %8d %8d %8d%n", n, Math.log(n) / Math.log(2),
                              sorted.height(), random.height(), Avl.h(avl.root));
        }
    }
}
