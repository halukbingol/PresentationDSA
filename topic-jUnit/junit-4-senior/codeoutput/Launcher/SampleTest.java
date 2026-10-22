import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SampleTest {
    @Test
    void ok() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void broken() {
        assertEquals(3, 1 + 1, "arithmetic");
    }
}
