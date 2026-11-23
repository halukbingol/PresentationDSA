import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TS_Prime_jUnit {

	@Test
	void ts1_smallPrimes() {
		assertTrue(Prime.isPrime(2));
		assertTrue(Prime.isPrime(3));
		assertTrue(Prime.isPrime(7));
	}

	@Test
	void ts2_evenNumbers() {
		assertFalse(Prime.isPrime(4));
		assertFalse(Prime.isPrime(10));
	}
}
