package grades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class GpaTest {
    @Test
    void weightedByCredits() {
        assertEquals(3.0, Gpa.of(List.of(new Course("CSE101", 6, "AA"), new Course("MATH151", 2, "FF"),
                new Course("PHYS101", 4, "BB"))), 1e-9);
    }
}
