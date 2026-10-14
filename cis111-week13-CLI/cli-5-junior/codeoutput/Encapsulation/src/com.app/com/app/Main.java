package com.app;

import com.greet.internal.Words;   // not exported!

public class Main {
    public static void main(String[] args) {
        System.out.println(Words.hello());
    }
}
