import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssertionsTest {
    @Test
    void equality() {
        assertEquals(4, 2 + 2);
        assertNotEquals(5, 2 + 2);
        assertEquals("Ayşe", "Ay" + "şe");
    }

    @Test
    void truth() {
        assertTrue("yeditepe".startsWith("yedi"));
        assertFalse("".length() > 0);
    }

    @Test
    void nullOrNot() {
        String nothing = null;
        assertNull(nothing);
        assertNotNull("something");
    }

    @Test
    void doublesWithTolerance() {
        assertEquals(0.3, 0.1 + 0.2, 1e-9);
    }

    @Test
    void arrays() {
        assertArrayEquals(new int[] {1, 2, 3}, new int[] {1, 2, 3});
    }

    @Test
    void exceptions() {
        assertThrows(ArithmeticException.class, () -> System.out.println(1 / 0));
    }
}
