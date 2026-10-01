public class BreakContinue {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;     // go to the next i
            }
            if (i > 7) {
                break;        // leave the loop
            }
            System.out.println("adding " + i);
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}
