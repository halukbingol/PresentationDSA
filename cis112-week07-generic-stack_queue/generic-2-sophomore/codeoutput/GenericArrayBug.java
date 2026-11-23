public class GenericArrayBug {
    public static void main(String[] args) {
        // T[] a = new T[10];    // BUG: does not compile
        Object[] a = new Object[10];
        String[] s = (String[]) a;   // BUG: ClassCastException at runtime
    }
}