import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

class TimeTest {
	/** How often n can be halved until it is 1; n must be >= 1. */
	static int halvings(int n) {
		int count = 0;
		while (n != 1) {                       // a bug: never 1 if n <= 0
			n = n / 2;
			count++;
		}
		return count;
	}

	@Test
	void eight() {
		assertEquals(3, halvings(8));
	}

	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
	void zeroIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> halvings(0));
	}

	@Test
	@Disabled("the specification for 1 is not decided yet")
	void one() {
		assertEquals(0, halvings(1));
	}
}
