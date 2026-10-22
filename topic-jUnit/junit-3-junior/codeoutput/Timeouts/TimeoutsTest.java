import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class TimeoutsTest {
    static long slowFibonacci(int n) {
        return n < 2 ? n : slowFibonacci(n - 1) + slowFibonacci(n - 2);
    }

    @Test
    void fastEnough() {
        assertTimeout(Duration.ofMillis(500), () -> slowFibonacci(25));
    }

    @Test
    void tooSlowButRunsToTheEnd() {
        assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(300));
    }

    @Test
    void tooSlowAndStopped() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(3000));
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void wholeTestWithTimeout() throws InterruptedException {
        Thread.sleep(1000);
    }
}
