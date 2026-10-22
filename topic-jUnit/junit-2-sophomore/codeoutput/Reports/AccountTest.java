import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("An account")
class AccountTest {
    Account account;

    @BeforeEach
    void open() {
        account = new Account("Ayşe");
    }

    @Test
    @DisplayName("starts with balance 0")
    void startsEmpty() {
        assertEquals(0, account.balance());
    }

    @Nested
    @DisplayName("after a deposit of 100")
    class AfterDeposit {
        @BeforeEach
        void deposit() {
            account.deposit(100);
        }

        @Test
        @DisplayName("has balance 100")
        void balance() {
            assertEquals(100, account.balance());
        }

        @Test
        @DisplayName("allows withdrawing 30")
        void withdraw() {
            account.withdraw(30);
            assertEquals(70, account.balance());
        }

        @Test
        @DisplayName("refuses withdrawing 150")
        void overdraw() {
            IllegalStateException e = assertThrows(IllegalStateException.class,
                    () -> account.withdraw(150));
            assertEquals("insufficient funds: 100", e.getMessage());
        }
    }
}
