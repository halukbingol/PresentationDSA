package edu.yeditepe.greet;

/** Greets people in Turkish or English. */
public class Greeter {
    private Greeter() { }          // no objects needed

    /**
     * Builds a greeting.
     * @param name    who to greet
     * @param turkish {@code true} for Turkish
     * @return the greeting
     */
    public static String greet(String name, boolean turkish) {
        return (turkish ? "Merhaba, " : "Hello, ") + name + "!";
    }
}
