package edu.yeditepe.app;

import edu.yeditepe.greet.internal.Formatter;   // not exported!

public class Main {
    public static void main(String[] args) {
        System.out.println(Formatter.decorate("sneaky"));
    }
}
