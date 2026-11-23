public class Injection {
    public static void main(String[] args) {
        String user = "x' OR '1'='1";                    // typed by an attacker
        String sql = "SELECT * FROM users WHERE name = '" + user + "'";
        System.out.println(sql);                         // always true!
        String safe = "SELECT * FROM users WHERE name = ?";
        System.out.println(safe + "   with parameter: " + user);
    }
}
