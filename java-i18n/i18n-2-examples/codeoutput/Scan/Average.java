import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);   // uses the default locale!
        double a = in.nextDouble(), b = in.nextDouble();
        System.out.println("average = " + (a + b) / 2);
    }
}
