import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** Both sides of every boundary, the ends, and just outside. */
class StrongTest {
	@Test
	void boundaries() {
		assertEquals('F', Grades.letterGrade(0));
		assertEquals('F', Grades.letterGrade(59));
		assertEquals('D', Grades.letterGrade(60));
		assertEquals('D', Grades.letterGrade(69));
		assertEquals('C', Grades.letterGrade(70));
		assertEquals('C', Grades.letterGrade(79));
		assertEquals('B', Grades.letterGrade(80));
		assertEquals('B', Grades.letterGrade(89));
		assertEquals('A', Grades.letterGrade(90));
		assertEquals('A', Grades.letterGrade(100));
	}

	@Test
	void outside() {
		assertThrows(IllegalArgumentException.class, () -> Grades.letterGrade(-1));
		assertThrows(IllegalArgumentException.class, () -> Grades.letterGrade(101));
	}
}
