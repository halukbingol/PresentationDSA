public class Server {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                System.out.println("shutdown hook: closing files, saving state")));
        System.out.println("server running");
        Thread.sleep(60_000);                       // pretend to work
        System.out.println("finished normally");
    }
}
