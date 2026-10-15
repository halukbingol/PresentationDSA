public class GenericArray<T> {
    private T[] a = new T[10];  // not allowed

    public static void main(String[] args) {
        System.out.println(new GenericArray<String>().a.length);
    }
}
