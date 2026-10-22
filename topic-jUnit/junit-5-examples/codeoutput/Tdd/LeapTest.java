import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LeapTest {
    @ParameterizedTest
    @CsvSource({ "2024, true", "2026, false", "1900, false", "2000, true" })
    void leapYears(int year, boolean leap) {
        assertEquals(leap, Leap.isLeap(year), "year " + year);
    }
}
