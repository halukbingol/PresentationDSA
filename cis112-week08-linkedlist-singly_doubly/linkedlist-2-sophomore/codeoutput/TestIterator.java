public class TestIterator {
    public static void main(String[] args) {
        SinglyLinked<String> s = new SinglyLinked<>();
        s.addFirst("one"); s.addFirst("two"); s.addFirst("three");
        StringBuilder sb = new StringBuilder();
        for (String w : s) sb.append(w).append(' ');
        System.out.println("for-each: " + sb.toString().trim());
    }
}
