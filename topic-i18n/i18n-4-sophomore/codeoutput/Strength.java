import java.text.Collator;
import java.util.Locale;

public class Strength {
    public static void main(String[] args) {
        Collator c = Collator.getInstance(Locale.of("tr"));
        String[][] pairs = {{"ilaç", "İlaç"}, {"cam", "çam"}, {"ilik", "ılık"}, {"Ankara", "ankara"}};
        int[] levels = {Collator.PRIMARY, Collator.SECONDARY, Collator.TERTIARY};
        String[] names = {"PRIMARY", "SECONDARY", "TERTIARY"};
        for (int i = 0; i < levels.length; i++) {
            c.setStrength(levels[i]);
            StringBuilder line = new StringBuilder(String.format("%-10s", names[i]));
            for (String[] p : pairs)
                line.append(String.format("%s=%s:%-6s ", p[0], p[1], c.equals(p[0], p[1])));
            System.out.println(line);
        }
    }
}
