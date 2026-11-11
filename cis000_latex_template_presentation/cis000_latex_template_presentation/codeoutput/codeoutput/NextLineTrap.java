import java.util.Scanner;

public class NextLineTrap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Age: ");
        int age = in.nextInt();         // reads 19, not the Enter
        System.out.print("Name: ");
        String name = in.nextLine();    // reads the rest: ""
        System.out.println();
        System.out.println("[" + name + "] is " + age);
        name = in.nextLine();           // now the real name
        System.out.println("[" + name + "] is " + age);
    }
}
