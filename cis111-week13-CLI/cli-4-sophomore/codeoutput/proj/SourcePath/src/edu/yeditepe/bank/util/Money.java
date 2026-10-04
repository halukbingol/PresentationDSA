package edu.yeditepe.bank.util;

/** Formats money amounts. */
public class Money {
    private Money() { }

    /** Formats cents as lira, e.g. 13049 as "130.49 TL". */
    public static String format(long cents) {
        return String.format("%d.%02d TL", cents / 100, cents % 100);
    }
}
