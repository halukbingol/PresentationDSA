package edu.yeditepe.hello;

public class Hello {
    public static void main(String[] args) {
        String who = args.length > 0 ? args[0] : "World";
        System.out.println("Hello, " + who + "!");
    }
}
