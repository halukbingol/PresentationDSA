import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class SourcesTest {
    static Stream<Arguments> deposits() {
        return Stream.of(Arguments.of(50, 50), Arguments.of(1, 1), Arguments.of(250, 250));
    }

    @ParameterizedTest(name = "deposit {0} gives balance {1}")
    @MethodSource("deposits")
    void fromAMethod(int amount, int expected) {
        Account a = new Account("Ali");
        a.deposit(amount);
        assertEquals(expected, a.balance());
    }

    @ParameterizedTest(name = "{0}: {1}")
    @CsvFileSource(resources = "/owners.csv", numLinesToSkip = 1)
    void fromAFile(String owner, int deposit) {
        Account a = new Account(owner);
        a.deposit(deposit);
        assertEquals(owner, a.owner());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void noOwner(String owner) {
        assertNotEquals("Ayşe", new Account(owner).owner());
    }
}
