import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void averageOfMissingGrades() {
        assertEquals(0.0, new Calculator().average(null));
    }
}
