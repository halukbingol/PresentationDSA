public class App {
    public static void main(String[] args) {
        String who = System.getProperty("greeting", "Hello");
        System.out.println(who + ", args = " + String.join(" ", args));
    }
}
