public class Greet {
    public static void main(String[] args) {
        System.out.println("args.length = " + args.length);
        for (String name : args) {
            System.out.println("Merhaba " + name);
        }
        System.out.println("First: " + args[0]);
    }
}
