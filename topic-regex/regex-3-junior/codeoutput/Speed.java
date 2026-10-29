import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Speed {
    static final String[] INPUTS = { "CSE101", "cis111", "MATH151", "CSE102" };
    static final Pattern CODE = Pattern.compile("[A-Z]{3}\\d{3}");
    static int hits;

    static long ms(Predicate<String> test) {
        long t0 = System.nanoTime();
        for (int i = 0; i < 2_000_000; i++)
            if (test.test(INPUTS[i % 4])) hits++;
        return (System.nanoTime() - t0) / 1_000_000;
    }

    public static void main(String[] args) {
        for (int round = 1; round <= 2; round++) {
            long a = ms(s -> s.matches("[A-Z]{3}\\d{3}"));
            long b = ms(s -> CODE.matcher(s).matches());
            System.out.printf("round %d: matches %d ms, Pattern %d ms%n", round, a, b);
        }
    }
}
