import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CourseCodeTest {
    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({ "CSE101, true", "MATH151, true", "CIS111, true", "cse101, false",
                 "CSE1010, false", "CS101, false", "CSE 101, false", "'', false" })
    void codes(String input, boolean valid) {
        assertEquals(valid, CourseCode.isValid(input));
    }
}
