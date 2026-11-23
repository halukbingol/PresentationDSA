import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TH_Prime_jUnit {

	@Test
	void th1_one() {
		assertFalse(Prime.isPrime(1));
	}

	@Test
	void th2_nine() {
		assertFalse(Prime.isPrime(9));
	}

	@Test
	void th3_thirteen() {
		assertTrue(Prime.isPrime(13));
	}

	@Test
	void th4_fifteen() {
		assertFalse(Prime.isPrime(15));
	}
}
