public class Crash {
    static int average(int[] a) {
        int sum = 0;
        for (int x : a) sum += x;
        return sum / a.length;
    }

    public static void main(String[] args) {
        System.out.println(average(new int[] {4, 8}));
        System.out.println(average(new int[] {}));
    }
}
