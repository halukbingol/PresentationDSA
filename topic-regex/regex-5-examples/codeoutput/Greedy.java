import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Greedy {
    public static void main(String[] args) {
        String html = "<b>Bold</b> and <b>more</b>";
        for (String regex : new String[] { "<b>.*</b>", "<b>.*?</b>", "<b>[^<]*</b>" }) {
            Matcher m = Pattern.compile(regex).matcher(html);
            System.out.printf("%-14s", regex);
            while (m.find()) System.out.print(" [" + m.group() + "]");
            System.out.println();
        }
    }
}
