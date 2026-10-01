package edu.yeditepe.intro;

import java.util.Scanner;

public class ConsoleInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers? ");
        int n = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += in.nextInt();
        }
        System.out.println("sum = " + sum);
    }
}
