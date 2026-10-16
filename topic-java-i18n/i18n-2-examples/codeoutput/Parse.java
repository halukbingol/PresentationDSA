import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Parse {
    public static void main(String[] args) throws ParseException {
        String typed = "1.234,5";                         // as a Turkish user types it
        NumberFormat tr = NumberFormat.getInstance(Locale.of("tr", "TR"));
        NumberFormat us = NumberFormat.getInstance(Locale.US);
        System.out.println("Turkish rules: " + tr.parse(typed));
        System.out.println("US rules:      " + us.parse(typed)); // stops at ','
        System.out.println("parseDouble:   " + Double.parseDouble("3,5"));
    }
}
