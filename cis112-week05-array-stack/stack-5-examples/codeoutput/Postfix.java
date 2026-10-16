public class Postfix {
    static int eval(String expr) {
        IntStack s = new IntStack(20);
        for (String tok : expr.split(" ")) {
            if (tok.matches("-?\\d+")) {
                s.push(Integer.parseInt(tok));
            } else {
                int b = s.pop(), a = s.pop();            // b first!
                s.push(switch (tok) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> throw new IllegalArgumentException(tok);
                });
            }
            System.out.printf("  %-3s %s%n", tok, s);
        }
        return s.pop();
    }

    public static void main(String[] args) {
        System.out.println("= " + eval("3 4 + 2 *"));
        System.out.println("= " + eval("5 1 2 + 4 * + 3 -"));
    }
}
