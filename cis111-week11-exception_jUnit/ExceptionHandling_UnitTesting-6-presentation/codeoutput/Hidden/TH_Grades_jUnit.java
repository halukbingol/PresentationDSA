import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** The hidden tests: the grader has them. */
class TH_Grades_jUnit {

	@Test
	void th1_seventyFive() {
		assertEquals('C', Grades.letterGrade(75));
	}

	@Test
	void th2_ninety() {
		assertEquals('A', Grades.letterGrade(90));
	}

	@Test
	void th3_sixty() {
		assertEquals('D', Grades.letterGrade(60));
	}

	@Test
	void th4_zero() {
		assertEquals('F', Grades.letterGrade(0));
	}

	@Test
	void th5_hundred() {
		assertEquals('A', Grades.letterGrade(100));
	}
}
