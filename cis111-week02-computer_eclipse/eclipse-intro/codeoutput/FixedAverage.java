package edu.yeditepe.intro;

public class FixedAverage {
    static double average(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {     // fix 1: start at 0
            sum += values[i];
        }
        return (double) sum / values.length;          // fix 2: real division
    }

    public static void main(String[] args) {
        int[] grades = {85, 90, 72};
        System.out.println("average = " + average(grades));
    }
}
