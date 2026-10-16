import java.util.Scanner;

public class GradeBad {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Midterm: ");
        int midterm = in.nextInt();
        System.out.print("Final: ");
        int fin = in.nextInt();
        double total = 0.4 * midterm + 0.6 * fin;
        System.out.println("Total: " + total);
        System.out.println(total >= 50 ? "Passed" : "Failed");
    }
}
