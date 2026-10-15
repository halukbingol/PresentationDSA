import java.lang.ref.WeakReference;

public class Loitering {
    static Object[] leaky = new Object[4], clean = new Object[4];
    static int leakySize, cleanSize;

    public static void main(String[] args) {
        leaky[leakySize++] = new byte[50_000_000];       // push 50 MB
        clean[cleanSize++] = new byte[50_000_000];

        // pop: we only keep a WeakReference, which does not keep an object alive
        WeakReference<Object> fromLeaky = new WeakReference<>(leaky[--leakySize]);
        WeakReference<Object> fromClean = new WeakReference<>(clean[--cleanSize]);
        clean[cleanSize] = null;                          // the only difference

        System.gc();
        System.out.println("popped from leaky stack still in memory: " + (fromLeaky.get() != null));
        System.out.println("popped from clean stack still in memory: " + (fromClean.get() != null));
    }
}
