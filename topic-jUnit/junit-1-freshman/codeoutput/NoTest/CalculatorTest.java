import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    void addsTwoNumbers() {
        assertEquals(5, new Calculator().add(2, 3));
    }
}
