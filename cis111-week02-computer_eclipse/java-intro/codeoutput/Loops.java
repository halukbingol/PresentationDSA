public class Loops {
    public static void main(String[] args) {
        // for: when you know how many times
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // while: when you don't know in advance
        int n = 1;
        while (n < 100) {
            n = n * 2;
        }
        System.out.println("first power of 2 >= 100: " + n);
    }
}
