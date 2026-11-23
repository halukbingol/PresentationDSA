public class TestDoubly {
    public static void main(String[] args) {
        DoublyLinked<Integer> d = new DoublyLinked<>();
        for (int i = 1; i <= 3; i++) d.addLast(i);
        System.out.println("size: " + d.size());
        System.out.println("remove 2: " + d.remove(2));
        System.out.println("size: " + d.size());
    }
}
