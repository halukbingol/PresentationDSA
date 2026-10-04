package textutil;

public class Text {
    public static String box(String s) {
        String line = "+" + "-".repeat(s.length() + 2) + "+";
        return line + "\n| " + s + " |\n" + line;
    }
}
