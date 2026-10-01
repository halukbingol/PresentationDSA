public class Factorial {
    static long factorial(int n) {
        if (n <= 1) {
            return 1;                    // base case
        }
        return n * factorial(n - 1);     // recursive case
    }

    public static void main(String[] args) {
        for (int n = 0; n <= 20; n += 5) {
            System.out.println(n + "! = " + factorial(n));
        }
    }
}
