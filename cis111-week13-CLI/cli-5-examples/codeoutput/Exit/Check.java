public class Check {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("usage: java Check <number>");
            System.exit(2);                  // 2: wrong usage
        }
        int n = Integer.parseInt(args[0]);
        if (n < 0) {
            System.err.println(n + " is negative");
            System.exit(1);                  // 1: failure
        }
        System.out.println(n + " is fine"); // 0: success
    }
}
