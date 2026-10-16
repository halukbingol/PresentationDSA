public class CallStack {
    static int fact(int n, String indent) {
        System.out.println(indent + "call   fact(" + n + ")");
        int r = (n <= 1) ? 1 : n * fact(n - 1, indent + "  ");
        System.out.println(indent + "return " + r);
        return r;
    }

    static int depth = 0;
    static void forever() {
        depth++;
        forever();                     // no base case
    }

    public static void main(String[] args) {
        fact(4, "");
        try {
            forever();
        } catch (StackOverflowError e) {
            System.out.println(e + " after about " + depth / 1000 * 1000 + " calls");
        }
    }
}
