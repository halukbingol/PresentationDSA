import java.util.Objects;

/** A bank account; amounts are in whole liras. */
public class Account {
	private final String owner;
	private int balance;
	private boolean closed;

	/** @throws NullPointerException if owner is null */
	public Account(String owner) {
		this.owner = Objects.requireNonNull(owner, "owner");
	}

	/**
	 * Adds amount to the balance.
	 * @throws IllegalArgumentException if amount <= 0
	 * @throws IllegalStateException if the account is closed
	 */
	public void deposit(int amount) {
		checkOpen();
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be > 0: " + amount);
		}
		balance += amount;
	}

	/**
	 * Takes amount from the balance.
	 * @throws InsufficientFundsException if amount > balance (checked)
	 */
	public void withdraw(int amount) throws InsufficientFundsException {
		checkOpen();
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be > 0: " + amount);
		}
		if (amount > balance) {
			throw new InsufficientFundsException(
					owner + " has " + balance + ", wants " + amount, amount - balance);
		}
		balance -= amount;
	}

	public void close() {
		closed = true;
	}

	public int getBalance() {
		return balance;
	}

	private void checkOpen() {
		if (closed) {
			throw new IllegalStateException("account of " + owner + " is closed");
		}
	}
}
