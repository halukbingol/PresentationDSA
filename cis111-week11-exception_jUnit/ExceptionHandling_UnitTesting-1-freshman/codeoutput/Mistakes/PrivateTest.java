import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PrivateTest {

	@Test
	private void boilingPoint() {      // private
		assertEquals(212.0, Temperature.toFahrenheit(100), 1e-9);
	}
}
