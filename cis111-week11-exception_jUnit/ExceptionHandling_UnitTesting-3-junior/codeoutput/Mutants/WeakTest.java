import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** One score from the middle of every letter: all green. */
class WeakTest {
	@Test
	void oneOfEach() {
		assertEquals('A', Grades.letterGrade(95));
		assertEquals('B', Grades.letterGrade(85));
		assertEquals('C', Grades.letterGrade(75));
		assertEquals('D', Grades.letterGrade(65));
		assertEquals('F', Grades.letterGrade(40));
	}
}
