public class Info {
    public static void main(String[] args) {
        record Point(int x, int y) { }          // records: Java 16+
        System.out.println("Java 17 version: " + new Point(3, 4));
    }
}
