import java.text.BreakIterator;

public class Units {
static String hex(String s) {                       // code points as hex
    StringBuilder b = new StringBuilder();
    s.codePoints().forEach(c -> b.append(String.format("%X ", c)));
    return b.toString().trim();
}

    static int graphemes(String s) {                    // what a reader calls "characters"
        BreakIterator it = BreakIterator.getCharacterInstance();
        it.setText(s);
        int n = 0;
        while (it.next() != BreakIterator.DONE) n++;
        return n;
    }
    public static void main(String[] args) {
        String[] samples = {"ağaç", "Cafe\u0301", "a\uD83D\uDC4D\uD83C\uDFFDb"};  // last: thumbs up + skin tone
        for (String s : samples)
            System.out.printf("%-22s chars=%d code points=%d graphemes=%d%n", hex(s),
                s.length(), s.codePointCount(0, s.length()), graphemes(s));
        String t = samples[2];
        System.out.println("charAt(1) = " + Integer.toHexString(t.charAt(1))
            + " (half of a surrogate pair)");
    }
}
