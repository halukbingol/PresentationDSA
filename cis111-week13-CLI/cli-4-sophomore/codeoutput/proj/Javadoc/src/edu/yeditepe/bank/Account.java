package edu.yeditepe.bank;

import edu.yeditepe.bank.util.Money;

/** A bank account that holds an amount in cents. */
public class Account {
    private final String owner;
    private long cents;

    /** Creates an empty account for {@code owner}. */
    public Account(String owner) {
        this.owner = owner;
    }

    /** Adds {@code c} cents. */
    public void deposit(long c) {
        cents += c;
    }

    @Override
    public String toString() {
        return owner + ": " + Money.format(cents);
    }
}
