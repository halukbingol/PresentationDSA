package hello;

public class Greeter {
    public static String greet(String name) {
        return "Merhaba, " + name + "!";
    }

    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "Dünya";
        System.out.println(greet(name));
    }
}
