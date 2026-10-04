package edu.yeditepe.hello;

public class Greeter {
    private final String name;

    public Greeter(String name) {
        this.name = name;
    }

    public String greet() {
        return "Hello from " + name + "!";
    }
}
