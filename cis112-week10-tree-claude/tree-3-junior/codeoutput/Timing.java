import java.util.*;

public class Timing {
    static final int N = 20_000;

    public static void main(String[] args) {
        for (int round = 0; round < 3; round++) {           // the last round counts
            long t0 = System.nanoTime();
            PlainBst plain = new PlainBst();
            for (int i = 0; i < N; i++) plain.insert(i);
            long t1 = System.nanoTime();
            Avl avl = new Avl();
            for (int i = 0; i < N; i++) avl.insert(i);
            long t2 = System.nanoTime();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < N; i++) map.put(i, i);
            long t3 = System.nanoTime();
            if (round == 2) {
                System.out.printf("%,d sorted inserts%n", N);
                System.out.printf("plain BST   %6d ms   height %,d%n", (t1 - t0) / 1_000_000, plain.height());
                System.out.printf("AVL         %6d ms   height %d%n", (t2 - t1) / 1_000_000, Avl.h(avl.root));
                System.out.printf("TreeMap     %6d ms   (red-black tree)%n", (t3 - t2) / 1_000_000);
            }
        }
    }
}
