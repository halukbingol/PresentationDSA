package edu.yeditepe.intro;

public class RefactorAfter {
    public static void main(String[] args) {
        int[] midterm = {70, 85, 90};
        int[] finalExam = {60, 95, 80};

        System.out.println("midterm avg: " + average(midterm));
        System.out.println("final avg: " + average(finalExam));
    }

    private static double average(int[] scores) {
        int sum = 0;
        for (int x : scores) sum += x;
        return (double) sum / scores.length;
    }
}
