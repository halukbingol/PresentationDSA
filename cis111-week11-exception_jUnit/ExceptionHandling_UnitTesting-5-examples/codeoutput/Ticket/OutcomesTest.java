import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** Three tests, three outcomes. */
class OutcomesTest {

	@Test
	void pass() {
		assertEquals(100, Ticket.price(40));
	}

	@Test
	void failure() {
		assertEquals(60, Ticket.price(40));
	}

	@Test
	void error() {
		assertEquals(0, Ticket.price(-3));
	}
}
