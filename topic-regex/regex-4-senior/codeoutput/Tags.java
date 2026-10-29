import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tags {
    public static void main(String[] args) {
        Pattern bold = Pattern.compile("<b>(.*?)</b>");
        for (String html : new String[] { "<b>x</b>", "<b>x<b>y</b>z</b>", "<b title=\"a</b>\">x</b>" }) {
            Matcher m = bold.matcher(html);
            System.out.println(html + "  ->  " + (m.find() ? m.group(1) : "-"));
        }
    }
}
