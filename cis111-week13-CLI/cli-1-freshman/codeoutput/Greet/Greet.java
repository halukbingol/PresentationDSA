import java.util.Scanner;

public class Greet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Your name: ");
        String name = in.nextLine();
        System.out.print("Your age: ");
        int age = in.nextInt();
        System.out.println();
        System.out.println("Hi " + name + ", next year you will be "
                + (age + 1) + ".");
    }
}
