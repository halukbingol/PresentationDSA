public class Account {
    private final String owner;
    private int balance;

    public Account(String owner) {
        this.owner = owner;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive: " + amount);
        }
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalStateException("insufficient funds: " + balance);
        }
        balance -= amount;
    }

    public int balance() {
        return balance;
    }

    public String owner() {
        return owner;
    }
}
