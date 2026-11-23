import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TicketTest {

	@Test
	void childPaysHalf() {
		int age = 12;                             // arrange
		int actual = Ticket.price(age);           // act
		assertEquals(50, actual);                 // assert
	}

	@Test
	void oneFromEveryClass() {
		assertEquals(0, Ticket.price(3));
		assertEquals(50, Ticket.price(12));
		assertEquals(100, Ticket.price(40));
	}

	@Test
	void boundaries() {
		assertEquals(0, Ticket.price(0));
		assertEquals(0, Ticket.price(6));
		assertEquals(50, Ticket.price(7));
		assertEquals(50, Ticket.price(17));
		assertEquals(100, Ticket.price(18));
	}

	@Test
	void negativeAge() {
		assertThrows(IllegalArgumentException.class, () -> Ticket.price(-1));
	}
}
