package com.app;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("com.app.i18n.Messages",
                                                     Locale.forLanguageTag(args[0]));
        System.out.println("[" + rb.getLocale() + "] " + rb.getString("hello"));
    }
}
