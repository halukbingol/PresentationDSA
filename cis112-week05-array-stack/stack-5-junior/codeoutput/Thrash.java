public class Thrash {
    /** copies made by m push/pop pairs on a stack of size n, if we shrink at 1/k full */
    static long copies(int n, int k, int m) {
        int capacity = n, size = n;                    // full, at the boundary
        long copied = 0;
        for (int i = 0; i < m; i++) {
            if (size == capacity) { copied += size; capacity *= 2; }    // push
            size++;
            size--;                                                     // pop
            if (size > 0 && size == capacity / k) { copied += size; capacity /= 2; }
        }
        return copied;
    }

    public static void main(String[] args) {
        int n = 1024, m = 1000;
        System.out.printf("%d push/pop pairs on a full stack of %d%n", m, n);
        System.out.printf("shrink at 1/2 full: %,10d copies%n", copies(n, 2, m));
        System.out.printf("shrink at 1/4 full: %,10d copies%n", copies(n, 4, m));
    }
}
