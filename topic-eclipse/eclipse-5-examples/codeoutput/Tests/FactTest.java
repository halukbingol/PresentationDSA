import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FactTest {
    @Test
    void small() {
        assertEquals(24, Fact.fact(4));
    }

    @Test
    void zero() {
        assertEquals(1, Fact.fact(0));
    }

    @Test
    void twenty() {
        assertEquals(2432902008176640000L, Fact.fact(20));
    }
}
