public class OutOfBounds {
    public static void main(String[] args) {
        String s = "Java";
        System.out.println(s.charAt(3));
        System.out.println(s.charAt(4));    // no index 4
    }
}
