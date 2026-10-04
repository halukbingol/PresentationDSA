package edu.yeditepe.greet.api;

import edu.yeditepe.greet.internal.Formatter;

public class Greeter {
    public static String greet(String name) {
        return Formatter.decorate("Hello, " + name);
    }
}
