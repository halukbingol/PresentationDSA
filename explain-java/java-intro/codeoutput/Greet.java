import java.util.Scanner;

public class Greet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Your name: ");
        String name = in.nextLine();
        System.out.print("Birth year: ");
        int year = in.nextInt();
        int age = 2026 - year;

        System.out.println();
        System.out.println("Hello " + name + "!");
        System.out.println("You turn " + age + " in 2026.");
        in.close();
    }
}
