import java.util.regex.Pattern;

public class Csv {
    static long ms(Pattern p, String line) {
        long t0 = System.nanoTime();
        p.matcher(line).matches();
        return (System.nanoTime() - t0) / 1_000_000;
    }

    public static void main(String[] args) {
        Pattern lazy = Pattern.compile("^(.*?,){11}P.*");
        Pattern exact = Pattern.compile("^([^,\\r\\n]*,){11}P.*");
        for (int fields = 12; fields <= 24; fields += 4) {
            String line = "1,".repeat(fields - 1) + "1";   // no P: the match must fail
            System.out.printf("%2d fields: (.*?,) %4d ms   ([^,]*,) %d ms%n",
                    fields, ms(lazy, line), ms(exact, line));
        }
    }
}
