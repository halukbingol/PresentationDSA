package edu.yeditepe.intro;

public class RefactorBefore {
    public static void main(String[] args) {
        int[] midterm = {70, 85, 90};
        int[] fin = {60, 95, 80};

        int s1 = 0;
        for (int x : midterm) s1 += x;
        System.out.println("midterm avg: " + (double) s1 / midterm.length);

        int s2 = 0;
        for (int x : fin) s2 += x;
        System.out.println("final avg: " + (double) s2 / fin.length);
    }
}
