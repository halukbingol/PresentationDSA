package grades;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RangeTest {
    @Test
    @Tag("fast")
    void inRange() {
        assertTrue(0 <= 75 && 75 <= 100);
    }
}
