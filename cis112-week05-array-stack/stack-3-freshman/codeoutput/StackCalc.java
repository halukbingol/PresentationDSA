import java.util.Scanner;

public class StackCalc {
    public static void main(String[] args) {
        IntStack s = new IntStack(5);
        Scanner in = new Scanner(System.in);
        System.out.println("commands: push N, pop, peek, size, quit");
        while (true) {
            String cmd = in.next();
            if (cmd.equals("quit")) break;
            try {
                switch (cmd) {
                    case "push" -> {
                        int x = in.nextInt();
                        s.push(x);
                        System.out.println("push " + x + "  -> " + s);
                    }
                    case "pop"  -> System.out.println("pop     -> " + s.pop() + ", now " + s);
                    case "peek" -> System.out.println("peek    -> " + s.peek());
                    case "size" -> System.out.println("size    -> " + s.size());
                    default     -> System.out.println(cmd + "    -> unknown command");
                }
            } catch (IllegalStateException e) {
                System.out.println(cmd + "     -> error: " + e.getMessage());
            }
        }
        System.out.println("bye");
    }
}
