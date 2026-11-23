import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountTest {
	private Account account;

	@BeforeEach
	void setUp() {                                 // runs before every test
		account = new Account("Ada");
		account.deposit(100);
	}

	@Test
	@DisplayName("a deposit adds up")
	void depositAddsUp() {
		account.deposit(50);
		assertEquals(150, account.getBalance());
	}

	@Test
	@DisplayName("withdraw all, then nothing is left")
	void withdrawAll() throws InsufficientFundsException {
		account.withdraw(100);
		assertEquals(0, account.getBalance());
	}

	@Test
	@DisplayName("too much: checked exception, balance unchanged")
	void tooMuch() {
		InsufficientFundsException e = assertThrows(InsufficientFundsException.class,
				() -> account.withdraw(130));
		assertAll(
				() -> assertEquals(30, e.getMissing()),
				() -> assertEquals("Ada has 100, wants 130", e.getMessage()),
				() -> assertEquals(100, account.getBalance()));
	}

	@Test
	@DisplayName("a negative deposit is rejected")
	void negativeDeposit() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> account.deposit(-5));
		assertEquals("amount must be > 0: -5", e.getMessage());
	}

	@Test
	@DisplayName("a closed account takes nothing")
	void closed() {
		account.close();
		assertThrows(IllegalStateException.class, () -> account.deposit(10));
	}
}
