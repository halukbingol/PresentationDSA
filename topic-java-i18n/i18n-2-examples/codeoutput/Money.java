import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Money {
    public static void main(String[] args) {
        Locale tr = Locale.of("tr", "TR");
        BigDecimal price = new BigDecimal("1234.5");
        for (String code : new String[] {"TRY", "EUR", "USD", "JPY"}) {
            Currency c = Currency.getInstance(code);
            NumberFormat f = NumberFormat.getCurrencyInstance(tr);
            f.setCurrency(c);                       // Turkish format, other currency
            System.out.printf("%s  digits=%d  symbol(en)=%-4s  %-22s %s%n", code,
                c.getDefaultFractionDigits(), c.getSymbol(Locale.US),
                c.getDisplayName(tr), f.format(price));
        }
    }
}
