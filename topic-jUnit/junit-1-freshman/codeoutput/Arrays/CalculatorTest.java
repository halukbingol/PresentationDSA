import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void sameArray() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertEquals(expected, actual);
    }
}
