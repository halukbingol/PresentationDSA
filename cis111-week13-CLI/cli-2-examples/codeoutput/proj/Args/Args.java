public class Args {
    public static void main(String[] args) {
        System.out.println(args.length + " argument(s)");
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = [" + args[i] + "]");
        }
    }
}
