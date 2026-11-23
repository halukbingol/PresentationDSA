import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** Only express parcels: the else branch never runs. */
class ExpressTest {

	@Test
	void express1kg() {
		assertEquals(30, Shipping.cost(1, true));
	}

	@Test
	void express3kg() {
		assertEquals(70, Shipping.cost(3, true));
	}
}
