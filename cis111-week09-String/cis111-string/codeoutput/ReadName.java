import java.util.Scanner;

public class ReadName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Your name: ");
        String name = in.nextLine();
        System.out.print("Your city: ");
        String city = in.nextLine();
        System.out.println();
        System.out.println("Hi " + name + " from " + city + "!");
        System.out.println("Your name starts with " + name.charAt(0));
    }
}
