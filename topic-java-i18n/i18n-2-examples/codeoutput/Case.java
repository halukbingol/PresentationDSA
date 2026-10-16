import java.util.Locale;

public class Case {
    public static void main(String[] args) {
        Locale tr = Locale.of("tr", "TR");
        System.out.println("title  -> " + "title".toUpperCase(tr) + "   " + "title".toUpperCase(Locale.ROOT));
        System.out.println("TITLE  -> " + "TITLE".toLowerCase(tr) + "   " + "TITLE".toLowerCase(Locale.ROOT));
        System.out.println("FILE equals file? " + "FILE".toLowerCase(tr).equals("file"));
        System.out.println("straße -> " + "straße".toUpperCase(Locale.GERMANY));
        System.out.println("ılık   -> " + "ılık".toUpperCase(tr) + "   İSTANBUL -> " + "İSTANBUL".toLowerCase(tr));
    }
}
