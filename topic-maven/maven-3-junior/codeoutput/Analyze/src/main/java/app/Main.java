package app;

import lib.TextUtil;
import lib.a.Greeting;
import lib.b.Farewell;

public class Main {
    public static void main(String[] args) {
        System.out.println(Greeting.hello());
        System.out.println(Farewell.bye());
        System.out.println(TextUtil.shout("bitti"));
    }
}
