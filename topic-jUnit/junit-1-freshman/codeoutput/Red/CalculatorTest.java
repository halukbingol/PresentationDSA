import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void addsTwoNumbers() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    void maxOfTwo() {
        Calculator calc = new Calculator();
        assertEquals(7, calc.max(7, 4));
        assertEquals(7, calc.max(4, 7));
    }

    @Test
    void averageOfGrades() {
        Calculator calc = new Calculator();
        assertEquals(72.5, calc.average(new int[] {70, 75}), 1e-9);
    }
}
