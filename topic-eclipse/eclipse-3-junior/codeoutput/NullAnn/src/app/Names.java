package app;

import ann.NonNull;
import ann.Nullable;

public class Names {
    static @Nullable String find(String id) {
        return id.equals("1") ? "Ayşe" : null;
    }

    static int length(@NonNull String s) {
        return s.length();
    }

    public static void main(String[] args) {
        String name = find("2");
        System.out.println(length(name));
        System.out.println(length(null));
    }
}
