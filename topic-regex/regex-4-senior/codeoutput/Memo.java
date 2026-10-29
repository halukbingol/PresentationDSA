import java.util.regex.Pattern;

public class Memo {
    static void time(String regex, int n) {
        String text = "a".repeat(n);
        long t0 = System.nanoTime();
        boolean found = Pattern.compile(regex).matcher(text).matches();
        long ms = (System.nanoTime() - t0) / 1_000_000;
        System.out.printf("%-10s n=%-6d %b %5d ms%n", regex, n, found, ms);
    }

    public static void main(String[] args) {
        time("(a+)+b", 30);
        time("(a+)+b", 5_000);
        time("(a+)+b", 10_000);
        for (int n = 20; n <= 26; n += 2) time("(a+)+\\1b", n);
    }
}
