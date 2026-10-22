import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TcKimlikTest {
    @Test
    void acceptsAValidNumber() {
        assertTrue(TcKimlik.isValid("10000000146"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "1000000014", "100000001460", "1000000014a" })
    void rejectsWrongLengthOrLetters(String id) {
        assertFalse(TcKimlik.isValid(id));
    }

    @Test
    void rejectsALeadingZero() {
        assertFalse(TcKimlik.isValid("00000000146"));
    }

    @Test
    void rejectsAWrongCheckDigit() {
        assertFalse(TcKimlik.isValid("10000000147"));
    }
}
