import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TemperatureTest {

	@Test
	void boilingPoint() {
		assertEquals(212.0, Temperature.toFahrenheit(100), 1e-9);
	}

	@Test
	void minusFortyIsTheSame() {
		assertEquals(-40.0, Temperature.toFahrenheit(-40), 1e-9);
	}

	@Test
	void freezing() {
		assertTrue(Temperature.isFreezing(0));
		assertTrue(Temperature.isFreezing(-3.5));
		assertFalse(Temperature.isFreezing(0.1));
	}

	@Test
	void coldest() {
		assertEquals(-2.5, Temperature.coldest(new double[] {4, -2.5, 0}), 1e-9);
	}

	@Test
	void coldestOfNothing() {
		assertThrows(IllegalArgumentException.class,
				() -> Temperature.coldest(new double[0]));
	}
}
