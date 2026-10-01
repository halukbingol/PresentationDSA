package edu.yeditepe.intro;

public class BuggyAverage {
    static double average(int[] values) {
        int sum = 0;
        for (int i = 1; i < values.length; i++) {
            sum += values[i];
        }
        return sum / values.length;
    }

    public static void main(String[] args) {
        int[] grades = {85, 90, 72};
        System.out.println("average = " + average(grades));
    }
}
