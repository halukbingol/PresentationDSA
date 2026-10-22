import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void addsTwoNumbers() {
        int result = new Calculator().add(2, 2);
        assertEquals(result, 5);
    }
}
