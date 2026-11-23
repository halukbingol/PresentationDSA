import org.junit.jupiter.api.Test;

class NoImportTest {

	@Test
	void boilingPoint() {
		assertEquals(212.0, Temperature.toFahrenheit(100), 1e-9);
	}
}
