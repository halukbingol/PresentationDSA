import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** The visible tests: the student has them. */
class TS_Grades_jUnit {

	@Test
	void ts1_eightyFive() {
		assertEquals('B', Grades.letterGrade(85));
	}

	@Test
	void ts2_ninetyFive() {
		assertEquals('A', Grades.letterGrade(95));
	}

	@Test
	void ts3_forty() {
		assertEquals('F', Grades.letterGrade(40));
	}
}
