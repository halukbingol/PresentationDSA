import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Messages {
    public static void main(String[] args) {
        Object[] v = {"Ali", 3, 1234.5};
        String en = "{0} sent {1} files ({2,number,#,##0.0} KB).";
        String tr = "{0}, {1} dosya gönderdi ({2,number,#,##0.0} KB).";
        System.out.println(new MessageFormat(en, Locale.US).format(v));
        System.out.println(new MessageFormat(tr, Locale.of("tr")).format(v));

        String plural = "{0,choice,0#no files|1#one file|1<{0,number,integer} files}";
        for (int n : new int[] {0, 1, 2, 1500})
            System.out.println(new MessageFormat(plural, Locale.US).format(new Object[] {n}));

        System.out.println(MessageFormat.format("Don't open {0}", "x.txt"));  // ' is special
        System.out.println(MessageFormat.format("Don''t open {0}", "x.txt"));
    }
}
