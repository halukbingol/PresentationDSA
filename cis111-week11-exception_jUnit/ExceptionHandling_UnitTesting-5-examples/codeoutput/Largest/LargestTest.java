import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LargestTest {

	@Test
	void mixed() {
		assertEquals(9, Largest.max(new int[] {4, 9, 2}));
	}

	@Test
	void largestFirstOrLast() {
		assertEquals(9, Largest.max(new int[] {9, 4, 2}));
		assertEquals(9, Largest.max(new int[] {4, 2, 9}));
	}

	@Test
	void allNegative() {
		assertEquals(-2, Largest.max(new int[] {-7, -2, -5}));
	}

	@Test
	void empty() {
		assertThrows(IllegalArgumentException.class, () -> Largest.max(new int[0]));
	}
}
