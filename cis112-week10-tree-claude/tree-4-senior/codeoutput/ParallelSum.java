import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelSum {
    record Node(long value, Node left, Node right) { }

    static Node build(int depth, long[] next) {               // a perfect tree
        if (depth < 0) return null;
        Node l = build(depth - 1, next);
        long v = next[0]++;
        return new Node(v, l, build(depth - 1, next));
    }

    static long sum(Node t) { return t == null ? 0 : t.value() + sum(t.left()) + sum(t.right()); }

    static class SumTask extends RecursiveTask<Long> {
        final Node t; final int depth;
        SumTask(Node t, int depth) { this.t = t; this.depth = depth; }

        @Override protected Long compute() {
            if (t == null) return 0L;
            if (depth > 6) return sum(t);                     // small enough: sequential
            SumTask left = new SumTask(t.left(), depth + 1);
            left.fork();                                      // run the left part in parallel
            long right = new SumTask(t.right(), depth + 1).compute();
            return t.value() + right + left.join();
        }
    }

    public static void main(String[] args) {
        Node root = build(22, new long[] {1});                // 2^23 - 1 nodes
        for (int round = 0; round < 3; round++) {
            long t0 = System.nanoTime();
            long s1 = sum(root);
            long t1 = System.nanoTime();
            long s2 = ForkJoinPool.commonPool().invoke(new SumTask(root, 0));
            long t2 = System.nanoTime();
            if (round == 2)
                System.out.printf("sum %,d = %,d%nsequential %d ms, parallel %d ms on %d processors%n",
                    s1, s2, (t1 - t0) / 1_000_000, (t2 - t1) / 1_000_000,
                    Runtime.getRuntime().availableProcessors());
        }
    }
}
