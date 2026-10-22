import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class GreeterTest {
    @Test
    void morning() {
        Greeter g = new Greeter(() -> LocalTime.of(9, 0));
        assertEquals("Günaydın, Ayşe", g.greet("Ayşe"));
    }

    @Test
    void evening() {
        Greeter g = new Greeter(() -> LocalTime.of(20, 30));
        assertEquals("İyi akşamlar, Ali", g.greet("Ali"));
    }
}
