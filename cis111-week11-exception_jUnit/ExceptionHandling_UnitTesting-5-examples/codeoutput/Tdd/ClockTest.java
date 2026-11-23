import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ClockTest {

	@Test
	void zero() {
		assertEquals("00:00:00", Clock.toClock(0));
	}

	@Test
	void secondsOnly() {
		assertEquals("00:00:59", Clock.toClock(59));
	}

	@Test
	void oneMinute() {
		assertEquals("00:01:00", Clock.toClock(60));
	}

	@Test
	void allParts() {
		assertEquals("01:01:01", Clock.toClock(3661));
	}

	@Test
	void lastSecondOfTheDay() {
		assertEquals("23:59:59", Clock.toClock(86399));
	}

	@Test
	void negative() {
		assertThrows(IllegalArgumentException.class, () -> Clock.toClock(-1));
	}
}
