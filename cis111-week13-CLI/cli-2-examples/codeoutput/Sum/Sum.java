import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long sum = 0;
        while (in.hasNext()) {
            if (in.hasNextLong()) {
                sum += in.nextLong();
            } else {
                System.err.println("skipping: " + in.next());
            }
        }
        System.out.println("sum = " + sum);
    }
}
