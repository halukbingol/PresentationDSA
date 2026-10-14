package com.greet.api;

import com.greet.internal.Words;

public class Greeter {
    public static String hello(String name) {
        return Words.hello() + ", " + name + "!";
    }
}
