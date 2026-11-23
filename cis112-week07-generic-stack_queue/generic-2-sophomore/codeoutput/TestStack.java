public class TestStack {
    public static void main(String[] args) {
        ArrayStack<Integer> s = new ArrayStack<>(2);
        for (int i = 1; i <= 5; i++) {
            s.push(i);
            System.out.println("push " + i + " -> " + s);
        }
        System.out.println("peek = " + s.peek());
        System.out.println("size = " + s.size());
        while (!s.isEmpty()) System.out.println("pop  = " + s.pop());
    }
}