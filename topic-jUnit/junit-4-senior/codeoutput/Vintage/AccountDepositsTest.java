import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountDepositsTest {
    private java.util.List<Integer> deposits;

    @BeforeEach
    void setUp() {
        deposits = new java.util.ArrayList<>();
    }

    @Test
    void sumOfDeposits() {
        deposits.add(100);
        deposits.add(50);
        assertEquals(150, deposits.stream().mapToInt(Integer::intValue).sum(), "sum");
    }

    @Test
    void emptyHasNoFirst() {
        assertThrows(IndexOutOfBoundsException.class, () -> deposits.get(0));
    }
}
