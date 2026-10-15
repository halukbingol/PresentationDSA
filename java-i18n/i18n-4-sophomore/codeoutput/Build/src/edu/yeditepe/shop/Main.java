package edu.yeditepe.shop;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        Locale l = args.length > 0 ? Locale.forLanguageTag(args[0]) : Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("edu.yeditepe.shop.i18n.Messages", l);

        int count = 3;
        BigDecimal total = new BigDecimal("1249.90").multiply(BigDecimal.valueOf(count));
        NumberFormat money = NumberFormat.getCurrencyInstance(l);
        money.setCurrency(Currency.getInstance("TRY"));      // prices are in lira
        String day = LocalDate.of(2026, 10, 20)
            .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(l));

        System.out.println(rb.getString("title"));
        System.out.println(text(rb, l, "items", count));
        System.out.println(text(rb, l, "total", money.format(total)));
        System.out.println(text(rb, l, "delivery", day));
    }

    static String text(ResourceBundle rb, Locale l, String key, Object... values) {
        return new MessageFormat(rb.getString(key), l).format(values);
    }
}
