public class Report {
    public static void main(String[] args) {
        int[] g = {70, 85, 90, 45};
        int s = 0;
        for (int x : g) {
            s += x;
        }
        System.out.println("Average: " + (double) s / g.length);
        int c = 0;
        for (int x : g) {
            if (x >= 50) {
                c++;
            }
        }
        System.out.println("Passed: " + c);
    }
}
