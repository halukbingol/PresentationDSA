import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class OutcomesTest {
    @Test
    void passes() {
        assertEquals(4, 2 + 2);
    }

    @Test
    void failsAnAssertion() {
        assertEquals(5, 2 + 2);
    }

    @Test
    void throwsAnException() {
        Integer.parseInt("dört");
    }

    @Test
    void abortedByAnAssumption() {
        assumeTrue(System.getenv("DATABASE_URL") != null);
        fail("never reached here");
    }

    @Test
    @Disabled("waiting for issue #42")
    void disabled() {
        fail("never runs");
    }
}
