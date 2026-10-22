import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Unsafe {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat old = new SimpleDateFormat("yyyy-MM-dd");      // NOT thread-safe
        DateTimeFormatter modern = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // immutable
        AtomicInteger badOld = new AtomicInteger(), badNew = new AtomicInteger();
        IntStream.range(0, 20_000).parallel().forEach(i -> {
            LocalDate d = LocalDate.of(2000 + i % 30, 1 + i % 12, 1 + i % 28);
            String expected = d.toString();
            try {
                Date parsed = old.parse(expected);
                if (!old.format(parsed).equals(expected)) badOld.incrementAndGet();
            } catch (Exception e) { badOld.incrementAndGet(); }
            if (!LocalDate.parse(expected, modern).format(modern).equals(expected))
                badNew.incrementAndGet();
        });
        System.out.println("wrong with SimpleDateFormat:  " + (badOld.get() > 0 ? "yes" : "no"));
        System.out.println("wrong with DateTimeFormatter: " + (badNew.get() > 0 ? "yes" : "no"));
    }
}
