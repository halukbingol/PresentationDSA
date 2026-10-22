public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public double average(int[] grades) {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return sum / grades.length;
    }
}
