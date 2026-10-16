public class Report {
    private static final int PASS_GRADE = 50;

    public static void main(String[] args) {
        int[] grades = {70, 85, 90, 45};
        System.out.println("Average: " + average(grades));
        System.out.println("Passed: " + countPassed(grades));
    }

    private static double average(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    private static int countPassed(int[] grades) {
        int count = 0;
        for (int grade : grades) {
            if (grade >= PASS_GRADE) {
                count++;
            }
        }
        return count;
    }
}
