import java.util.regex.Pattern;

public class Backref {
    public static void main(String[] args) {
        String text = "Bu bu ödev çok çok kolay, the the end.";
        Pattern doubled = Pattern.compile("\\b(\\p{L}+)\\s+\\1\\b",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        doubled.matcher(text).results().forEach(r -> System.out.println("[" + r.group() + "]"));
        System.out.println(doubled.matcher(text).replaceAll("$1"));

        Pattern tag = Pattern.compile("<(\\w+)>(.*?)</\\1>");
        tag.matcher("<b>kalın</b> <i>eğik</i> <b>yanlış</i>").results()
                .forEach(r -> System.out.println(r.group(1) + ": " + r.group(2)));
    }
}
