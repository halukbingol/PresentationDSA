public class Methods {
    static double average(int[] values) {      // parameter: an int array
        int sum = 0;
        for (int v : values) sum += v;
        return (double) sum / values.length;   // return value: a double
    }

    static int max(int a, int b) { return (a > b) ? a : b; }
    static double max(double a, double b) { return (a > b) ? a : b; }

    public static void main(String[] args) {
        int[] grades = {78, 91, 85};
        System.out.println("average: " + average(grades));
        System.out.println("max(3, 8) = " + max(3, 8));
        System.out.println("max(2.5, 1.5) = " + max(2.5, 1.5));
    }
}
