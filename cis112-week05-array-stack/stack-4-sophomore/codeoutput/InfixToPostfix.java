public class InfixToPostfix {
    static int prec(String op) { return op.equals("+") || op.equals("-") ? 1 : 2; }

    /** Dijkstra's shunting-yard algorithm; tokens are separated by spaces */
    static String toPostfix(String infix) {
        StackADT<String> ops = new ArrayStack<>();
        StringBuilder out = new StringBuilder();
        for (String t : infix.split(" ")) {
            if (t.matches("\\d+")) {
                out.append(t).append(' ');
            } else if (t.equals("(")) {
                ops.push(t);
            } else if (t.equals(")")) {
                while (!ops.peek().equals("(")) out.append(ops.pop()).append(' ');
                ops.pop();                                    // the "("
            } else {                                          // + - * /
                while (!ops.isEmpty() && !ops.peek().equals("(") && prec(ops.peek()) >= prec(t))
                    out.append(ops.pop()).append(' ');
                ops.push(t);
            }
        }
        while (!ops.isEmpty()) out.append(ops.pop()).append(' ');
        return out.toString().trim();
    }

    static int eval(String postfix) {
        StackADT<Integer> s = new ArrayStack<>();
        for (String t : postfix.split(" ")) {
            if (t.matches("\\d+")) { s.push(Integer.parseInt(t)); continue; }
            int b = s.pop(), a = s.pop();
            s.push(switch (t) { case "+" -> a + b; case "-" -> a - b; case "*" -> a * b; default -> a / b; });
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String[] tests = {"3 + 4 * 2", "( 3 + 4 ) * 2", "10 - 4 - 3", "2 * ( 3 + 4 ) - 10 / 5"};
        for (String t : tests) {
            String p = toPostfix(t);
            System.out.printf("%-24s -> %-20s = %d%n", t, p, eval(p));
        }
    }
}
