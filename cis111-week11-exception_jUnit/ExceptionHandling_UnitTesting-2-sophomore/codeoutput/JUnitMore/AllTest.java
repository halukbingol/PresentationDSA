import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AllTest {
	@Test
	void separate() {                      // stops at the first failure
		assertEquals('A', Grades.letterGrade(89));
		assertEquals('A', Grades.letterGrade(80));
	}

	@Test
	void together() {                      // reports every failure
		assertAll("letter grades",
				() -> assertEquals('A', Grades.letterGrade(89)),
				() -> assertEquals('A', Grades.letterGrade(80)));
	}
}
