import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LegacyAccountTest {
    private java.util.List<Integer> deposits;

    @Before
    public void setUp() {
        deposits = new java.util.ArrayList<>();
    }

    @Test
    public void sumOfDeposits() {
        deposits.add(100);
        deposits.add(50);
        assertEquals("sum", 150, deposits.stream().mapToInt(Integer::intValue).sum());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void emptyHasNoFirst() {
        deposits.get(0);
    }
}
