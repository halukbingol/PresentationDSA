public class Growing {
    public static void main(String[] args) {
        ArrayStack<Integer> s = new ArrayStack<>();
        for (int i = 1; i <= 9; i++) {
            s.push(i);
            System.out.printf("push %d   size %d   capacity %2d%n", i, s.size(), s.capacity());
        }
        while (s.size() > 1) {
            int x = s.pop();
            System.out.printf("pop  %d   size %d   capacity %2d%n", x, s.size(), s.capacity());
        }
    }
}
