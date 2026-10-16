import java.util.*;
import java.util.function.IntSupplier;

public class Bench {
    static final int N = 2_000_000;

    static long best(IntSupplier run) {          // best of 7 rounds, in ms
        long best = Long.MAX_VALUE;
        for (int round = 0; round < 7; round++) {
            long t = System.nanoTime();
            if (run.getAsInt() != N) throw new AssertionError();
            best = Math.min(best, System.nanoTime() - t);
        }
        return best / 1_000_000;
    }

    public static void main(String[] args) {
        Map<String, IntSupplier> runs = new LinkedHashMap<>();
        runs.put("IntArrayStack (int[])", () -> {
            IntArrayStack s = new IntArrayStack(); for (int i = 0; i < N; i++) s.push(i);
            int n = 0; while (!s.isEmpty()) { s.pop(); n++; } return n; });
        runs.put("ArrayStack<Integer>", () -> {
            ArrayStack<Integer> s = new ArrayStack<>(); for (int i = 0; i < N; i++) s.push(i);
            int n = 0; while (!s.isEmpty()) { s.pop(); n++; } return n; });
        runs.put("ArrayDeque<Integer>", () -> {
            Deque<Integer> s = new ArrayDeque<>(); for (int i = 0; i < N; i++) s.push(i);
            int n = 0; while (!s.isEmpty()) { s.pop(); n++; } return n; });
        runs.put("java.util.Stack<Integer>", () -> {
            Stack<Integer> s = new Stack<>(); for (int i = 0; i < N; i++) s.push(i);
            int n = 0; while (!s.isEmpty()) { s.pop(); n++; } return n; });
        runs.put("LinkedStack<Integer>", () -> {
            LinkedStack<Integer> s = new LinkedStack<>(); for (int i = 0; i < N; i++) s.push(i);
            int n = 0; while (!s.isEmpty()) { s.pop(); n++; } return n; });
        runs.put("LinkedList<Integer>", () -> {
            Deque<Integer> s = new LinkedList<>(); for (int i = 0; i < N; i++) s.push(i);
            int n = 0; while (!s.isEmpty()) { s.pop(); n++; } return n; });

        System.out.printf("%,d pushes + %,d pops, best of 7 rounds%n", N, N);
        runs.forEach((name, run) -> System.out.printf("%-26s %5d ms%n", name, best(run)));
    }
}
