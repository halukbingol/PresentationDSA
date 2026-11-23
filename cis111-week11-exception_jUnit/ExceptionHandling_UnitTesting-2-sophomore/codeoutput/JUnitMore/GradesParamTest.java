import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GradesParamTest {
	@ParameterizedTest(name = "{0} gives {1}")
	@CsvSource({"0, F", "59, F", "60, D", "69, D", "70, C", "79, C",
			"80, B", "89, B", "90, A", "100, A"})
	void boundaries(int score, char grade) {
		assertEquals(grade, Grades.letterGrade(score));
	}

	@ParameterizedTest(name = "{0} throws")
	@ValueSource(ints = {-1, 101, Integer.MIN_VALUE})
	void outside(int score) {
		assertThrows(IllegalArgumentException.class,
				() -> Grades.letterGrade(score));
	}
}
