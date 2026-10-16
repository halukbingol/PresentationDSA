public class Average {
    public static void main(String[] args) {
        int[] grades = {70, 85, 90};
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        double avg = sum / grades.length;
        System.out.println("Average: " + avg);
    }
}
