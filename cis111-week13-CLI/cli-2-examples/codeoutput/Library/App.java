import edu.yeditepe.greet.Greeter;

public class App {
    public static void main(String[] args) {
        System.out.println(Greeter.greet("Ayşe", true));
        System.out.println(Greeter.greet("Bob", false));
    }
}
