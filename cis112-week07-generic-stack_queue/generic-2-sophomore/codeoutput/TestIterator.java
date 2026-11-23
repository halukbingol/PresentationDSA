public class TestIterator {
    public static void main(String[] args) {
        ArrayStack<String> s = new ArrayStack<>(2);
        s.push("one");
        s.push("two");
        s.push("three");
        System.out.print("for-each: ");
        for (String w : s) System.out.print(w + " ");
        System.out.println();
    }
}