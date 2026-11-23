import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GradesTest {

	@Test
	void eightyFiveIsB() {
		assertEquals('B', Grades.letterGrade(85));
	}

	@Test
	void boundaries() {
		assertEquals('A', Grades.letterGrade(90));
		assertEquals('B', Grades.letterGrade(89));
		assertEquals('D', Grades.letterGrade(60));
		assertEquals('F', Grades.letterGrade(59));
	}

	@Test
	void ends() {
		assertEquals('F', Grades.letterGrade(0));
		assertEquals('A', Grades.letterGrade(100));
	}

	@Test
	void outsideIsAnError() {
		assertThrows(IllegalArgumentException.class, () -> Grades.letterGrade(101));
		assertThrows(IllegalArgumentException.class, () -> Grades.letterGrade(-1));
	}

	@Test
	void passing() {
		assertTrue(Grades.isPassing(60));
		assertFalse(Grades.isPassing(59));
	}

	@Test
	void average() {
		int[] scores = {70, 85, 90};
		assertEquals(81.667, Grades.average(scores), 0.001);
	}

	@Test
	void letterGradesOfAnArray() {
		char[] expected = {'B', 'F', 'A'};
		assertArrayEquals(expected, Grades.letterGrades(new int[] {85, 40, 95}));
	}
}
