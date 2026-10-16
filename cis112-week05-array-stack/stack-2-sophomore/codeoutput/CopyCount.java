public class CopyCount {
    /** elements copied while pushing n elements; grow(c) gives the new capacity */
    static long copies(int n, java.util.function.IntUnaryOperator grow) {
        long copied = 0;
        int capacity = 1;
        for (int size = 0; size < n; size++) {
            if (size == capacity) {           // full: copy everything into a new array
                copied += size;
                capacity = grow.applyAsInt(capacity);
            }
        }
        return copied;
    }

    public static void main(String[] args) {
        System.out.printf("%10s %12s %12s %15s%n", "n", "doubling", "x1.5", "+100");
        for (int n = 1_000; n <= 1_000_000; n *= 10) {
            System.out.printf("%,10d %,12d %,12d %,15d%n", n,
                copies(n, c -> 2 * c),
                copies(n, c -> c + Math.max(1, c / 2)),
                copies(n, c -> c + 100));
        }
    }
}
