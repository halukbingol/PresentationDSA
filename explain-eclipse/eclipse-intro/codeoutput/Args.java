package edu.yeditepe.intro;

public class Args {
    public static void main(String[] args) {
        System.out.println("Number of arguments: " + args.length);
        String name = args[0];
        int times = Integer.parseInt(args[1]);
        for (int i = 1; i <= times; i++) {
            System.out.println(i + ". Hello " + name);
        }
    }
}
