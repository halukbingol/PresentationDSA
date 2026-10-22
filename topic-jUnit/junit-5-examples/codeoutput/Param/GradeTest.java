import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GradeTest {
    @ParameterizedTest
    @CsvSource({ "100, AA", "90, AA", "89, BB", "70, BB", "69, CC", "50, CC", "49, FF", "0, FF" })
    void letterAtTheBorders(int score, String expected) {
        assertEquals(expected, Grade.letter(score));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, 101 })
    void outOfRange(int score) {
        assertThrows(IllegalArgumentException.class, () -> Grade.letter(score));
    }
}
