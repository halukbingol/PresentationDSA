import java.util.regex.Pattern;

public class Anchors {
    public static void main(String[] args) {
        String[] texts = { "cat", "dog", "catalog", "hotdog", "concat" };
        for (String regex : new String[] { "cat", "^cat|dog$", "^(cat|dog)$", "\\bcat\\b" }) {
            Pattern p = Pattern.compile(regex);
            System.out.printf("%-12s", regex);
            for (String t : texts) {
                System.out.printf(" %s:%s", t, p.matcher(t).find() ? "F" : "-");
            }
            System.out.println();
        }
        System.out.println("matches: " + "catalog".matches("cat") + ", find: "
                + Pattern.compile("cat").matcher("catalog").find());
    }
}
