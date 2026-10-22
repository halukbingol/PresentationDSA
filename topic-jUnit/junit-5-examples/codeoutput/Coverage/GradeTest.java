import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GradeTest {
    @Test
    void top() {
        assertEquals("AA", Grade.letter(95));
    }

    @Test
    void failing() {
        assertEquals("FF", Grade.letter(20));
    }
}
