/** Thrown when a withdrawal is larger than the balance. A checked exception. */
public class InsufficientFundsException extends Exception {
	private final int missing;

	public InsufficientFundsException(String message, int missing) {
		super(message);
		this.missing = missing;
	}

	/** Returns how much money is missing. */
	public int getMissing() {
		return missing;
	}
}
