import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** One more test, for the other branch. */
class NormalTest {

	@Test
	void normal1kg() {
		assertEquals(15, Shipping.cost(1, false));
	}
}
