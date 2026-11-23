import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PitfallsTest {

	@Test
	void doubleWithoutTolerance() {
		assertEquals(0.3, 0.1 + 0.2);
	}

	@Test
	void doubleWithTolerance() {
		assertEquals(0.3, 0.1 + 0.2, 1e-9);
	}

	@Test
	void arraysWithAssertEquals() {
		char[] expected = {'B', 'A'};
		char[] actual = Grades.letterGrades(new int[] {85, 95});
		assertEquals(expected, actual);
	}

	@Test
	void arraysWithAssertArrayEquals() {
		char[] expected = {'B', 'A'};
		char[] actual = Grades.letterGrades(new int[] {85, 95});
		assertArrayEquals(expected, actual);
	}

	@Test
	void hundredThrows() {
		assertThrows(IllegalArgumentException.class, () -> Grades.letterGrade(100));
	}
}
