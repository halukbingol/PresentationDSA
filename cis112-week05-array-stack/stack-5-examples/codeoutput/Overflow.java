public class Overflow {
    public static void main(String[] args) {
        IntStack s = new IntStack(3);
        for (int i = 1; i <= 4; i++) {
            try {
                s.push(i * 10);
                System.out.println("push " + i * 10 + " -> " + s);
            } catch (IllegalStateException e) {
                System.out.println("push " + i * 10 + " -> " + e.getMessage());
            }
        }
    }
}
