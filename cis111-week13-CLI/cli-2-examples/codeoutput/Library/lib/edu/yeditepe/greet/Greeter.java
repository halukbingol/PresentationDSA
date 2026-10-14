package edu.yeditepe.greet;

/** Greets people in Turkish or English. */
public class Greeter {
    /** @return a greeting for {@code name} */
    public static String greet(String name, boolean turkish) {
        return (turkish ? "Merhaba, " : "Hello, ") + name + "!";
    }
}
