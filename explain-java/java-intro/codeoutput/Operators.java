public class Operators {
    public static void main(String[] args) {
        int a = 17, b = 5;
        System.out.println("a + b = " + (a + b));
        System.out.println("a / b = " + (a / b));     // integer division
        System.out.println("a % b = " + (a % b));     // remainder
        System.out.println("a / 5.0 = " + (a / 5.0)); // double division

        double avg = (double) a / b;                  // cast
        System.out.println("avg = " + avg);

        a += 3;                                       // a = a + 3
        a++;                                          // a = a + 1
        System.out.println("a = " + a);
        System.out.println(a > 20 && b < 10);         // logical AND
    }
}
