import java.util.Locale;

public class LocaleBug {
    static boolean isEditCommand(String cmd) {
        return cmd.toUpperCase().equals("EDIT");       // default locale!
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.forLanguageTag("tr")); // a Turkish server
        System.out.println("edit  -> " + "edit".toUpperCase());
        System.out.println("check: " + isEditCommand("edit"));
        System.out.println("FILE  -> " + "FILE".toLowerCase());
        System.out.println("ROOT  -> " + "edit".toUpperCase(Locale.ROOT)
                + " " + "FILE".toLowerCase(Locale.ROOT));
    }
}
