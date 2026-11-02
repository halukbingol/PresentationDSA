import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class GradeBookTest {

	@Test
	void rowTotalsRagged() {
		int[][] t = {{1}, {2, 3}, {4, 5, 6}};
		assertArrayEquals(new int[] {1, 5, 15}, GradeBook.rowTotals(t));
	}

	@Test
	void columnAverages() {
		int[][] t = {{72, 85}, {55, 61}};
		assertArrayEquals(new double[] {63.5, 73.0}, GradeBook.columnAverages(t), 1e-9);
	}

	@Test
	void isRectangular() {
		assertTrue(GradeBook.isRectangular(new int[][] {{1, 2}, {3, 4}}));
		assertFalse(GradeBook.isRectangular(new int[][] {{1, 2}, {3}}));
		assertFalse(GradeBook.isRectangular(new int[0][]));
	}

	@Test
	void withBonusCells() {
		int[][] t = {{72, 98}, {55, 61}};
		int[][] expected = {{77, 100}, {60, 66}};
		assertArrayEquals(expected, GradeBook.withBonus(t, 5));    // cell by cell
	}

	@Test
	void withBonusKeepsInput() {
		int[][] t = {{72, 98}, {55, 61}};
		GradeBook.withBonus(t, 5);
		assertArrayEquals(new int[][] {{72, 98}, {55, 61}}, t);
	}

	@Test
	void withBonusWrongExpected() {
		int[][] t = {{72, 98}, {55, 61}};
		int[][] expected = {{77, 100}, {61, 66}};                  // 61? the test is wrong
		assertArrayEquals(expected, GradeBook.withBonus(t, 5));
	}
}
