import java.util.regex.Pattern;

public class Flags {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("yeditepe", Pattern.CASE_INSENSITIVE);
        System.out.println(p1.matcher("YEDITEPE").matches());
        System.out.println("YEDITEPE".matches("(?i)yeditepe"));

        Pattern grade = Pattern.compile("""
                (?<letter> [A-D][A-D] | FF )   # AA, BA, ..., DD or FF
                \\s* : \\s*                     # a colon with optional spaces
                (?<score> \\d{1,3} )           # the score
                """, Pattern.COMMENTS);
        System.out.println(grade.matcher("BA : 85").matches());

        String lines = "first line\nsecond line\nthird";
        System.out.println(Pattern.compile("^\\w+").matcher(lines).results().count());
        System.out.println(Pattern.compile("^\\w+", Pattern.MULTILINE).matcher(lines).results().count());
        System.out.println("a\nb".matches("a.b") + " " + "a\nb".matches("(?s)a.b"));
    }
}
