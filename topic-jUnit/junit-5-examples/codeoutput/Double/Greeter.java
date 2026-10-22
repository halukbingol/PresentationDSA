import java.time.LocalTime;
import java.util.function.Supplier;

public class Greeter {
    private final Supplier<LocalTime> clock;

    public Greeter(Supplier<LocalTime> clock) {
        this.clock = clock;
    }

    public String greet(String name) {
        int hour = clock.get().getHour();
        String part = hour < 12 ? "Günaydın" : hour < 18 ? "İyi günler" : "İyi akşamlar";
        return part + ", " + name;
    }
}
