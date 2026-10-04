public class Config {
    public static void main(String[] args) {
        String port = args.length > 0 ? args[0]                     // 1. argument
                : System.getProperty("port",                         // 2. -Dport=...
                    System.getenv().getOrDefault("PORT", "8080"));   // 3. env, 4. default
        System.out.println("port = " + port);
    }
}
