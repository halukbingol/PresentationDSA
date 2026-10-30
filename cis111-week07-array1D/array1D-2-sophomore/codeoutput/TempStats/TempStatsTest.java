import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TempStatsTest {

	@Test
	void maxOfMixed() {
		assertEquals(9, TempStats.max(new int[] {3, -2, 9, 4}));
	}

	@Test
	void maxOfAllNegative() {                  // Erzurum, January
		assertEquals(-3, TempStats.max(new int[] {-12, -8, -15, -3}));
	}

	@Test
	void countBelowZero() {
		assertEquals(3, TempStats.countBelow(new int[] {-12, 2, -15, -3}, 0));
	}

	@Test
	void changesOfFourDays() {
		assertArrayEquals(new int[] {4, -7, 12},
				TempStats.changes(new int[] {-12, -8, -15, -3}));
	}

	@Test
	void changesKeepsInput() {
		int[] t = {1, 5, 2};
		TempStats.changes(t);
		assertArrayEquals(new int[] {1, 5, 2}, t);
	}

	@Test
	void keepsInputWrongAssert() {             // compares arrows!
		int[] t = {1, 5, 2};
		TempStats.changes(t);
		assertEquals(new int[] {1, 5, 2}, t);
	}
}
