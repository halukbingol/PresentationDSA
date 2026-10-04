package edu.yeditepe.app;

import edu.yeditepe.greet.api.Greeter;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%4$s: %5$s%n");
        Logger.getLogger("app").info("starting");
        System.out.println(Greeter.greet("Yeditepe"));
    }
}
