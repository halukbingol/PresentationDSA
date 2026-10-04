public class Check {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n < 0) {
            System.err.println("error: negative number " + n);
            System.exit(2);
        }
        System.out.println(n + " squared is " + n * n);
    }
}
