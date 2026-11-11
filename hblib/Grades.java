public class Grades {
    public static void main(String[] args) {
        int[] marks = {72, 85, 90, 64, 78};
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        double average = (double) sum / marks.length;
        System.out.println("count   = " + marks.length);
        System.out.println("sum     = " + sum);
        System.out.println("average = " + average);
    }
}
