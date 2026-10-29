import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words {
    static final Pattern WORD = Pattern.compile("\\p{L}+");

    public static void main(String[] args) {
        String text = "Çay mı, kahve mi? Çay! Ama şekersiz çay.";
        Map<String, Integer> count = new TreeMap<>();
        Matcher m = WORD.matcher(text);
        while (m.find()) {
            count.merge(m.group().toLowerCase(java.util.Locale.forLanguageTag("tr")), 1, Integer::sum);
        }
        System.out.println(count);
        System.out.println("\\w+ finds: " + Pattern.compile("\\w+").matcher(text).results()
                .map(r -> r.group()).toList());
    }
}
