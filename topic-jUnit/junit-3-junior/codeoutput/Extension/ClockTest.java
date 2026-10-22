import static org.junit.jupiter.api.Assertions.*;

import java.time.Clock;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(FixedClockExtension.class)
class ClockTest {
    @Test
    void morningInIstanbul(Clock clock) {
        assertEquals(LocalTime.of(9, 30), LocalTime.now(clock));
    }

    @Test
    void notYetNoon(Clock clock) {
        assertTrue(LocalTime.now(clock).isAfter(LocalTime.NOON));
    }
}
