public class Depth {
    static int depth;

    static void down() {
        depth++;
        down();
    }

    public static void main(String[] args) {
        try {
            down();
        } catch (StackOverflowError e) {
            System.out.printf("depth reached: %,d%n", depth);
        }
    }
}
