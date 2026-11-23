public class Concat {
    static String greet(String name, int n) {
        return "Hello " + name + ", you have "
                + n + " messages";
    }

    public static void main(String[] args) {
        System.out.println(greet("Ayşe", 3));
    }
}
