import java.util.function.Supplier;

public class Memory {
    static final int N = 1_000_000;

    static long used() {
        for (int i = 0; i < 3; i++) System.gc();
        Runtime r = Runtime.getRuntime();
        return r.totalMemory() - r.freeMemory();
    }

    static void measure(String name, Supplier<Object> build) {
        long before = used();
        Object keep = build.get();                  // keep it alive while measuring
        long after = used();
        System.out.printf("%-22s %6.1f MB  %5.1f bytes per element%n",
                          name, (after - before) / 1e6, (after - before) / (double) N);
        if (keep.hashCode() == 42) System.out.print("");
    }

    public static void main(String[] args) {
        measure("IntArrayStack", () -> { var s = new IntArrayStack();
            for (int i = 0; i < N; i++) s.push(i + 1000); return s; });
        measure("ArrayStack<Integer>", () -> { var s = new ArrayStack<Integer>();
            for (int i = 0; i < N; i++) s.push(i + 1000); return s; });
        measure("LinkedStack<Integer>", () -> { var s = new LinkedStack<Integer>();
            for (int i = 0; i < N; i++) s.push(i + 1000); return s; });
    }
}
