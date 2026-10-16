public class Expr {
    static boolean isOp(Node n) { return n.left != null; }    // operators are internal nodes

    static int eval(Node n) {                                  // postorder
        if (!isOp(n)) return Integer.parseInt(n.value);
        int a = eval(n.left), b = eval(n.right);
        return switch (n.value) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default  -> a / b;
        };
    }

    static String infix(Node n) {                              // inorder, with brackets
        return isOp(n) ? "(" + infix(n.left) + " " + n.value + " " + infix(n.right) + ")" : n.value;
    }

    static String prefix(Node n) {                             // preorder
        return isOp(n) ? n.value + " " + prefix(n.left) + " " + prefix(n.right) : n.value;
    }

    static String postfix(Node n) {                            // postorder
        return isOp(n) ? postfix(n.left) + " " + postfix(n.right) + " " + n.value : n.value;
    }

    public static void main(String[] args) {
        Node e = new Node("*",
                     new Node("+", new Node("3"), new Node("4")),
                     new Node("-", new Node("5"), new Node("2")));
        System.out.println("infix   " + infix(e));
        System.out.println("prefix  " + prefix(e));
        System.out.println("postfix " + postfix(e));
        System.out.println("value   " + eval(e));
    }
}
