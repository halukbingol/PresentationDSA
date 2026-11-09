import java.util.Scanner;

public class EqualsTrap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();          // user types: yes
        System.out.println(answer == "yes");    // same object?
        System.out.println(answer.equals("yes"));
        String lit = "yes";
        System.out.println(lit == "yes");       // both literals
    }
}
