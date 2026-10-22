import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PriceTest {
    @Test
    void addsTwentyPercent() {
        assertEquals(120, Price.withVat(100));
    }

    @Test
    void zeroStaysZero() {
        assertEquals(0, Price.withVat(0));
    }
}
